package com.murat.graphql.resolver;

import com.murat.graphql.model.Author;
import com.murat.graphql.model.Book;
import com.murat.graphql.repository.AuthorRepository;
import com.murat.graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

/**
 * Author: Murat İlk
 * Date:12.03.2025
 */
@Controller
public class MutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public MutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        Author author = authorRepository.findById(bookInput.author.id()).orElseThrow();
        Book book = new Book(null, bookInput.title(), bookInput.genre(), author);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Author addAuthor(@Argument String name) {
        return authorRepository.save(new Author(null, name));
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument BookInput bookInput) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        Book book = optionalBook.get();
        book.setTitle(bookInput.title());
        book.setGenre(bookInput.genre());

        return bookRepository.save(book);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public record AuthorInput(Long id,String name){}
    public record BookInput(String title, String genre, AuthorInput author) {}
}
