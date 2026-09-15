import { Component, EventEmitter, Input, Output, SimpleChanges, OnChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookInterface } from '../../interface/book-interface';
import { BookService } from '../../service/book-service';

@Component({
  selector: 'app-book-form-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  styleUrl: './book-form-component.css',
  templateUrl: './book-form-component.html',
})
export class BookFormComponent implements OnChanges {
  @Input() bookToEdit: BookInterface | null = null;
  @Output() bookSaved = new EventEmitter<void>();

  book: BookInterface = this.getEmptyBook();

  constructor(private bookService: BookService) {}

  // Implementa o do método ngOnChanges para detectar mudanças na propriedade bookToEdit
  // e atualizar o formulário com os dados do livro a ser editado.
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['bookToEdit'] && this.bookToEdit) {
      this.book = { ...this.bookToEdit };
    }
  }

  // Implementa o método saveBook para decidir se deve adicionar um novo livro ou
  // atualizar um existente.
  public saveBook(): void {
    if (this.book.id) {
      this.updateBook();
    } else {
      this.addBook();
    }
  }

  public addBook(): void {
    this.bookService.createBook(this.book).subscribe({
      next: () => {
        alert('Livro criado com sucesso!');
        this.clearForm();
        this.bookSaved.emit();
      },
      error: (error) => console.error('Erro ao criar o livro.', error)
    });
  }

  public updateBook(): void {
    if (this.book.id) {
      this.bookService.updateBook(this.book.id, this.book).subscribe({
        next: () => {
          alert('Livro atualizado com sucesso!');
          this.clearForm();
          this.bookSaved.emit();   // emit() para notificar o componente pai que o livro foi atualizado.
        },
        error: (error) => console.error('Erro ao atualizar o livro.', error)
      });
    }
  }

  public clearForm(): void {
    this.book = this.getEmptyBook();
    this.bookToEdit = null;
  }

  private getEmptyBook(): BookInterface {
    return {
      title: '',
      authors: '',
      pages: 0,
      releaseYear: '',
      description: ''
    };
  }
}
