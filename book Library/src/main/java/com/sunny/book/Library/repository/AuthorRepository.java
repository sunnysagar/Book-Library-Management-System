package com.sunny.book.Library.repository;

import com.sunny.book.Library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findById(long id);
    Optional<Author> findByName(String name);
}
