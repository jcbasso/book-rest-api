package com.bbva.practitioner.bookrestapi.repositories;

import com.bbva.practitioner.bookrestapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
