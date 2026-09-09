package com.erick.leo.sistema_biblioteca.modules.library.service;

import com.erick.leo.sistema_biblioteca.modules.library.exception.BookNotFoundException;
import com.erick.leo.sistema_biblioteca.modules.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookDeleteService {

    @Autowired
    private BookRepository bookRepository;

    public String deleteBook(UUID id) {
        if(bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return "Livro deletado com sucesso!";
        }

        throw new BookNotFoundException();
    }
}
