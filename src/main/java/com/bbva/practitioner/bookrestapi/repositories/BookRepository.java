package com.bbva.practitioner.bookrestapi.repositories;

import com.bbva.practitioner.bookrestapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
