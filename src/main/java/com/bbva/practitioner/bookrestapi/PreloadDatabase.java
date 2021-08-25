package com.bbva.practitioner.bookrestapi;

import com.bbva.practitioner.bookrestapi.models.Author;
import com.bbva.practitioner.bookrestapi.models.Book;
import com.bbva.practitioner.bookrestapi.repositories.AuthorRepository;
import com.bbva.practitioner.bookrestapi.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreloadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner preloadBooks(BookRepository bookRepository, AuthorRepository authorRepository) {
        return args -> {
            Author author1 = authorRepository.save(new Author("Julio", "Cortázar"));
            logger.info("Preloading " + author1);
            Author author2 = authorRepository.save(new Author("Jorge Luis", "Borges"));
            logger.info("Preloading " + author2);

            logger.info("Preloading " + bookRepository.save(new Book("Rayuela", "Novela", 1963, author1)));
            logger.info("Preloading " + bookRepository.save(new Book("El Aleph", "Cuento", 1949, author2)));
        };
    }
}
