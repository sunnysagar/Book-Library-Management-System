package com.sunny.book.Library.model;

import jakarta.persistence.*;

import javax.validation.constraints.Pattern;


@Entity
@Table(name = "booksInfo")
public class Book {

    @Id
    private long id;
    private String title;

//    @ManyToOne
//    @JoinColumn(name = "authorName")
    private String authorName;

//    @Pattern(regexp = "^\\d{3}-\\d{10}$", message = "ISBN must be in the format xxx-xxxxxxxxxx")

    @Pattern(regexp = "^(?:ISBN(?:-13)?:?\\s*)?(?=[0-9]{13}$|(?=(?:[0-9]+[-\\ ]){3})[-\\ 0-9]{17}$)[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]$", message = "ISBN must be in the correct format")
    private String isbn;

//    private String isbn;

    private String publicationYear;

    public Book() {
    }

    public Book(long id, String title, String authorName, String isbn, String publicationYear) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
}
