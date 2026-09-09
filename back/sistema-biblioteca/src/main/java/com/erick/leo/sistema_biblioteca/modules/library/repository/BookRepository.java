package com.erick.leo.sistema_biblioteca.modules.library.repository;

import com.erick.leo.sistema_biblioteca.modules.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    List<BookEntity> findByTitleContainingIgnoreCase(String title);
}
