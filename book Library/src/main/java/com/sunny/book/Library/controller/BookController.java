package com.sunny.book.Library.controller;

import com.sunny.book.Library.model.Author;
import com.sunny.book.Library.model.Book;
import com.sunny.book.Library.service.AuthorService;
import com.sunny.book.Library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Valid
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



    // Read specific book by id from DB
    @GetMapping("{title}")
    public Book getBookDetails(@PathVariable("title") String  title){

        return bookService.getBookByName(title);
    }

    //Read All book from DB
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    // Adding the book into the DB
    @PostMapping
    public ResponseEntity<?> createBook( @RequestBody Book book){

//        String author = authorService.findByName(book.getAuthorName());
//        if(author.isBlank()){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }

        // set the book Id manually
        long booKId = generateBookId(book);
        book.setId(booKId);

        // create the book
        bookService.createBook(book);

//        bookService.createBook(book.getId(),book.getTitle(),book.getAuthorName(),book.getIsbn(),book.getPublicationYear());
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully.");

    }


    // updating the book into the DB
    @PutMapping("{bookId}")
    public String updateBook(@PathVariable("bookId") long bookId, @RequestBody Book book)
    {
        if(bookService.updateBook(bookId,book)){
            return "Book " + bookId + " updated successfully";

        }
        else {
            return "Not found";
        }

    }

    // Deleting book from DB
    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable("bookId") long bookId){
        bookService.deleteBookById(bookId);
        return "Book deleted successfully";
    }

    // Exception handler for validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
        // extract validation errors from the exception
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }


    private long generateBookId(Book book){
        return book.getId();
    }
}
