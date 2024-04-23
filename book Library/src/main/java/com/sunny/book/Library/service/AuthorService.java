package com.sunny.book.Library.service;

import com.sunny.book.Library.model.Author;
import com.sunny.book.Library.model.Book;
import com.sunny.book.Library.repository.AuthorRepository;
import com.sunny.book.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    BookRepository bookRepository;

//    public AuthorService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }


    // creating author
    public String createAuthor(long authorId, String name, String biography){

        Author author = new Author();

        author.setAuthorId(authorId);
        author.setName(name);
        author.setBiography(biography);

        authorRepository.save(author);

        return "success";
    }

    // getting author
    public Author getauthor(long authorId){
        return authorRepository.findById(authorId).get();
    }

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    // getting all books of particular author by authorName from DB

    public List<Book> getAllBookByAuthorName(String authorName){
        return bookRepository.findByAuthorNameIgnoreCaseContaining(authorName);
    }

    // updating author
    public String updateAuthor(long authorId, Author updatedAuthor){
        // check author is present or not
        Optional<Author> authorPresent = authorRepository.findById(authorId);

        if(authorPresent.isPresent()){
            // get the existing author
            Author existingAuthor = authorPresent.get();

            // Now update the existing author
            existingAuthor.setName(updatedAuthor.getName());
            existingAuthor.setBiography(updatedAuthor.getBiography());

            // save the updated one
            authorRepository.save(existingAuthor);
        }
        else
            return "Not Present";

        return "success";
    }

    // deleting author
    public String deleteAuthor(long id)
    {
        authorRepository.deleteById(id);
        return "success";
    }

    public String findByName(String name){
        authorRepository.findByName(name);
        return "Found";
    }

}
