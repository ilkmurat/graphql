package com.murat.graphql.repository;

import com.murat.graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Murat İlk
 * Date:12.03.2025
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
