package com.murat.graphql.resolver;

import com.murat.graphql.model.Book;
import com.murat.graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Author: Murat İlk
 * Date:12.03.2025
 */

@Controller
public class QueryResolver {

    private final BookRepository bookRepository;

    public QueryResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public List<Book> booksByGenre(@Argument String genre) {
        return bookRepository.findByGenre(genre);
    }

}
