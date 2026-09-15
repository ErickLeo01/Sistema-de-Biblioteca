package com.erick.leo.sistema_biblioteca.modules.library.controller;

import com.erick.leo.sistema_biblioteca.modules.library.DTO.BookDTO;
import com.erick.leo.sistema_biblioteca.modules.library.entity.BookEntity;
import com.erick.leo.sistema_biblioteca.modules.library.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/biblioteca")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookSignUpService bookSignUpService;

    @Autowired
    private BookAllService bookAllService;

    @Autowired
    private BookUpdateService bookUpdateService;

    @Autowired
    private BookDeleteService bookDeleteService;

    @Autowired
    private BookFindByTitleService bookFindByTitleService;

    @PostMapping("/cadastrar")
    public BookEntity createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookSignUpService.saveBook(bookDTO);
    }

    @GetMapping("/listar")
    public List<BookEntity> allBooks() {
        return bookAllService.allBooks();
    }

    @GetMapping("/pesquisar")
    public List<BookEntity> researchBook(@RequestParam String title) {
        return bookFindByTitleService.findByTitle(title);
    }

    @PutMapping("/atualizar/{id}")
    public BookEntity updateBook(@PathVariable UUID id, @Valid @RequestBody BookDTO bookDTO) {
        return bookUpdateService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public String deleteBook(@PathVariable UUID id) {
        return bookDeleteService.deleteBook(id);
    }
}