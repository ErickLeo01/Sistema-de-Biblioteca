import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BookInterface } from '../interface/book-interface';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private apiUrl = 'http://localhost:8080/biblioteca';

  constructor(private http: HttpClient) { }

  public getAllBook(): Observable<BookInterface[]> {
    return this.http.get<BookInterface[]>(`${this.apiUrl}/listar`);
  }

  public createBook(book: BookInterface): Observable<BookInterface> {
    return this.http.post<BookInterface>(`${this.apiUrl}/cadastrar`, book);
  }

  public updateBook(bookId: string, book: BookInterface): Observable<BookInterface> {
    return this.http.put<BookInterface>(`${this.apiUrl}/atualizar/${bookId}`, book);
  }

  public deleteBook(bookId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/deletar/${bookId}`);
  }

  // Ajustado para enviar a query string ?title= esperada pelo Spring Boot
  public findBookByTitle(title: string): Observable<BookInterface[]> {
    return this.http.get<BookInterface[]>(`${this.apiUrl}/pesquisar?title=${encodeURIComponent(title)}`);
  }
}
