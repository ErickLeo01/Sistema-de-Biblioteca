import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookService } from '../../service/book-service';
import { BookInterface } from '../../interface/book-interface';

@Component({
  selector: 'app-book-list-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  styleUrl: './book-list-component.css',
  templateUrl: './book-list-component.html',
})
export class BookListComponent implements OnInit {

  books: BookInterface[] = [];
  searchTitle: string = '';

  @Output() onEditBook = new EventEmitter<BookInterface>();

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.loadBooks();
  }

  public loadBooks(): void {
    this.bookService.getAllBook().subscribe({
      next: (response) => this.books = response,
      error: (error) => console.error('Erro ao buscar os livros.', error)
    });
  }

  public findBookByTitle(title: string): void {
    const searchTerm = title ? title.trim() : '';

    // Não faz nada nem recarrega todos os livros se clicar na busca com o campo vazio
    if (!searchTerm) {
      return;
    }

    this.bookService.findBookByTitle(searchTerm).subscribe({
      next: (response) => {
        this.books = response;
      },
      error: (error) => {
        console.warn('Livro não encontrado:', error);
        // Esvazia a lista para mostrar a mensagem "Nenhum livro encontrado."
        this.books = [];
      }
    });
  }

  public editBook(book: BookInterface): void {
    this.onEditBook.emit(book);
  }

  public deleteBook(id: string): void {
    if (confirm('Tem certeza que deseja excluir este livro?')) {
      this.bookService.deleteBook(id).subscribe({
        next: () => {
          alert('Livro deletado com sucesso!');
          this.loadBooks();
        },
        error: (error) => console.error('Erro ao deletar o livro.', error)
      });
    }
  }
}
