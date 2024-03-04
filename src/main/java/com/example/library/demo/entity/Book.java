package com.example.library.demo.entity;


import java.sql.Date;

public class Book {
    private int bookId = 0;
    private String bookTitle;
    private String author;
    private Date publicationDate;
    private String isbn;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String author, Date publicationDate, String isbn) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Book(String bookTitle, String author, Date publicationDate, String isbn) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.bookId = hashCode();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", isbn='" + isbn + '\'' +
                ", time='" + System.currentTimeMillis() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode() ? true : false;
    }
}
