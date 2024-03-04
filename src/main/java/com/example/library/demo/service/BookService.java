package com.example.library.demo.service;

import com.example.library.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    List<Book> queryBooksLimit(int limit, int offset);

    Book getBookById(int id);

    boolean addBook(Book book);

    boolean modifyBook(Book book);

    boolean deleteBook(int id);
}
