import { Component } from '@angular/core';
import { BookInterface } from './interface/book-interface';
import { BookFormComponent } from './components/book-form-component/book-form-component';
import { BookListComponent } from './components/book-list-component/book-list-component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [BookFormComponent, BookListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class AppComponent {

  selectedBook: BookInterface | null = null;
}
