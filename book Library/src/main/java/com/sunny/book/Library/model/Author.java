package com.sunny.book.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorInfo")
public class Author {

    @Id
    private long authorId;
    private String name;
    private String biography;

    public Author() {
    }

    public Author(long authorId, String name, String biography) {
        this.authorId = authorId;
        this.name = name;
        this.biography = biography;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
