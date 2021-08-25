package com.bbva.practitioner.bookrestapi.controllers;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Integer id) {
        super("Book with id " + id + " not found");
    }
}
