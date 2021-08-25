package com.bbva.practitioner.bookrestapi.controllers;

import com.bbva.practitioner.bookrestapi.models.Author;
import com.bbva.practitioner.bookrestapi.models.Book;
import com.bbva.practitioner.bookrestapi.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Author> getAuthorList() {
        return repository.findAll();
    }

    @GetMapping("{id}/books")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    List<Book> getBookListByAuthor(@PathVariable Integer id) {
        // TODO: Implementar este controller
        return new ArrayList<Book>();
    }
}
