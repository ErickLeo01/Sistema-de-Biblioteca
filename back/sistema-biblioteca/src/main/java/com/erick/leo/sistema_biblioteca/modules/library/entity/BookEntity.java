package com.erick.leo.sistema_biblioteca.modules.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Alterado de AUTO para UUID
    private UUID id;

    @NotBlank(message = "O título do livro não pode ser nulo.")
    private String title;

    @NotNull(message = "O número de páginas do livro não pode ser nulo.")
    @Min(value = 1, message = "O número de páginas não pode ser menor ou igual a 0.")
    private Integer pages;

    @NotBlank(message = "O nome do(s) autor(es) do livro não pode ser nulo.")
    private String authors;

    @NotNull(message = "O ano de publicação não pode ser nulo.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseYear;

    @NotBlank(message = "A descrição do livro não deve ser nula.")
    @Column(columnDefinition = "TEXT")
    private String description;
}