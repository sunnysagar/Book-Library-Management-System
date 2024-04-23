package com.sunny.book.Library.repository;

import com.sunny.book.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(long booKId);
    Optional<Book> findByTitle(String title);
    // Ignore wala baad me dekhte hai
    List<Book> findByAuthorNameIgnoreCaseContaining(String authorName);
}
