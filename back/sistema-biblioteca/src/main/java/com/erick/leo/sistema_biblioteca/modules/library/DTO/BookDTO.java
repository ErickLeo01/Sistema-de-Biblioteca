package com.erick.leo.sistema_biblioteca.modules.library.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record BookDTO(
        @NotBlank(message = "O título é obrigatório.")
        String title,

        @NotBlank(message = "O autor é obrigatório.")
        String authors,

        @NotNull(message = "O número de páginas é obrigatório.")
        @Min(value = 1, message = "O número de páginas deve ser maior que 0.")
        Integer pages,

        @NotNull(message = "A data de lançamento é obrigatória.")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate releaseYear,

        @NotBlank(message = "A descrição é obrigatória.")
        String description
) {}