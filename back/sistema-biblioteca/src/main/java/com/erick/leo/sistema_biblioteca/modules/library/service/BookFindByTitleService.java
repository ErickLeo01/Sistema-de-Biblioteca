package com.erick.leo.sistema_biblioteca.modules.library.service;

import com.erick.leo.sistema_biblioteca.modules.library.entity.BookEntity;
import com.erick.leo.sistema_biblioteca.modules.library.exception.BookNotFoundException;
import com.erick.leo.sistema_biblioteca.modules.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookFindByTitleService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> findByTitle(String title) {
        List<BookEntity> book = bookRepository.findByTitleContainingIgnoreCase(title);
        if(book.isEmpty()) {
            throw new BookNotFoundException();
        } else {
            return book;
        }
    }


}
