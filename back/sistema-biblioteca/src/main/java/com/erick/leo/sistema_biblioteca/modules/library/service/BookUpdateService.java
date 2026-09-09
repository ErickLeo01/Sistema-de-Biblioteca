package com.erick.leo.sistema_biblioteca.modules.library.service;

import com.erick.leo.sistema_biblioteca.modules.library.DTO.BookDTO;
import com.erick.leo.sistema_biblioteca.modules.library.entity.BookEntity;
import com.erick.leo.sistema_biblioteca.modules.library.exception.BookNotFoundException;
import com.erick.leo.sistema_biblioteca.modules.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookUpdateService {

    @Autowired
    private BookRepository bookRepository;

    public BookEntity updateBook(UUID id, BookDTO bookDTO) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());

        bookEntity.setTitle(bookDTO.title());
        bookEntity.setAuthors(bookDTO.authors());
        bookEntity.setPages(bookDTO.pages());
        bookEntity.setReleaseYear(bookDTO.releaseYear());
        bookEntity.setDescription(bookDTO.description());

        return bookRepository.save(bookEntity);
    }
}