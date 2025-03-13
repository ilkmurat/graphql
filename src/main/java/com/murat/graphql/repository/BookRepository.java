package com.murat.graphql.repository;

import com.murat.graphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Murat İlk
 * Date:12.03.2025
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);
}

