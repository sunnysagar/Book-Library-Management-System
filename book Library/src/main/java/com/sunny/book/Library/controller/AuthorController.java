package com.sunny.book.Library.controller;

import com.sunny.book.Library.model.Author;
import com.sunny.book.Library.model.Book;
import com.sunny.book.Library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // read the author by id from DB
    @GetMapping("{authorId}")
    public Author getAuthor(@PathVariable("authorId") long authorId){

        return authorService.getauthor(authorId);
    }

    // read all author from DB
    @GetMapping
    public List<Author> getAllAuthor(){
       return authorService.getAllAuthor();
    }

    // read all book by author name from DB
    @GetMapping("{authorName}/books")
    public List<Book> getAllBooksByAuthor(@PathVariable("authorName") String authorName){
        return authorService.getAllBookByAuthorName(authorName);
    }

    // create the author in DB
    @PostMapping
    public String createAuthor(@RequestBody Author author){
        authorService.createAuthor(author.getAuthorId(), author.getName(), author.getBiography());
        return "Author has added successfully";
    }

    // update the author details in DB
    @PutMapping("{authorId}")
    public String updateAuthor(@PathVariable("authorId") long authorId, @RequestBody Author author){
        authorService.updateAuthor(authorId,author);

        return "Author updated successfully";
    }

    // deleting author from DB
    @DeleteMapping("{authorId}")
    public String deleteAuthor(@PathVariable("authorId") long authorId){
        authorService.deleteAuthor(authorId);
        return "Deleting author is successfully";
    }
}
