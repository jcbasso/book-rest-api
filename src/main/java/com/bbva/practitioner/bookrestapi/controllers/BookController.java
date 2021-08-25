package com.bbva.practitioner.bookrestapi.controllers;

import com.bbva.practitioner.bookrestapi.models.Book;
import com.bbva.practitioner.bookrestapi.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Book> getBookList() {
        return this.repository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book newBook) {
        return this.repository.save(newBook);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book newBook) {
        return this.repository
                .findById(id)
                .map((Book book) -> {
                    if (newBook.getTitle() != null) {
                        book.setTitle(newBook.getTitle());
                    }
                    if (newBook.getGenre() != null) {
                        book.setGenre(newBook.getGenre());
                    }
                    if (newBook.getPublicationYear() != null) {
                        book.setPublicationYear(newBook.getPublicationYear());
                    }
                    return repository.save(book);
                })
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(@PathVariable Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }
    }
}
