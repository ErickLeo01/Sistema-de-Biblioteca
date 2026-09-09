package com.erick.leo.sistema_biblioteca.modules.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Livro não encontrado!");
    }
}
