package com.bbva.practitioner.bookrestapi;

import com.bbva.practitioner.bookrestapi.models.Book;
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
    CommandLineRunner preloadBooks(BookRepository repository) {
        return args -> {
            Book newBook = new Book("Rayuela", "Julio Cortázar", 1963);
            repository.save(newBook);
            logger.info("Loading book into database " + newBook);
        };
    }
}
