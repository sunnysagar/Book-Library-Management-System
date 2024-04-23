package com.sunny.book.Library.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rentalInfo")
public class RentalBook {

    @Id
    private long rentalId;

//    @ManyToOne
//    @JoinColumn(name = "bookId")
    private long bookId;

    private String rentalName;


    private Date rentalDate;

    private Date returnDate;

    public RentalBook() {
    }

    public RentalBook(long rentalId, long bookId, String rentalName, Date rentalDate, Date returnDate) {
        this.rentalId = rentalId;
        this.bookId = bookId;
        this.rentalName = rentalName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getRentalName() {
        return rentalName;
    }

    public void setRentalName(String rentalName) {
        this.rentalName = rentalName;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
