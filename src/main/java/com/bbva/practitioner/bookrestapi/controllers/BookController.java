package com.bbva.practitioner.bookrestapi.controllers;

import com.bbva.practitioner.bookrestapi.models.Book;
import com.bbva.practitioner.bookrestapi.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> getBookList() {
        return this.repository.findAll();
    }
}
