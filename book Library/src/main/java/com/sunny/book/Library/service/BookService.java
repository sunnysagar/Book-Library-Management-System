package com.sunny.book.Library.service;

import com.sunny.book.Library.model.Author;
import com.sunny.book.Library.model.Book;
import com.sunny.book.Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public String createBook(long bookId, String title, String authorName, String isbn, String publicationYear) {
//
//        Book book = new Book();
//        book.setId(bookId);
//        book.setTitle(title);
//        book.setAuthorName(authorName);
//        book.setIsbn(isbn);
//        book.setPublicationYear(publicationYear);
//
//        bookRepository.save(book);
//
//        return "success";
//
//    }

    // logic for wrong ISBN pattern
    public boolean isISBNValid(Book book){
        String isbn = book.getIsbn();
        String isbnPattern = "^\\d{3}-\\d{10}$";

        return isbn.matches(isbnPattern);
    }

    public String createBook(Book book){

        if(!isISBNValid(book)) {
           throw new IllegalArgumentException("Invalid ISBN format");
        }
        bookRepository.save(book);
        return "success";
    }

    public Book getBookByName(String title) {

        return bookRepository.findByTitle(title).orElse(null);

    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public boolean updateBook(long bookId, Book updatedBook){
        // check book is present or not
        Optional<Book> bookPresent = bookRepository.findById(bookId);

        if(bookPresent.isPresent()){
            // get the existing book
            Book existingBook = bookPresent.get();

            // Now update the existing book
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthorName(updatedBook.getAuthorName());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());

            // save the updated one
            bookRepository.save(existingBook);

            return true;
        }
        else
            return false;

//        return "success";

    }

    public String deleteBookById(long bookId){
        bookRepository.deleteById(bookId);

        return "success";
    }


}
