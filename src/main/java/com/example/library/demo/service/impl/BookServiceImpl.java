package com.example.library.demo.service.impl;

import com.example.library.demo.dao.BookDao;
import com.example.library.demo.entity.Book;
import com.example.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public List<Book> queryBooksLimit(int limit, int offset) {
        Map<String, Integer> parameter = new HashMap<>();
        parameter.put("limit", limit);
        parameter.put("offset", offset);
        return bookDao.queryBookLimit(parameter);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.queryBookById(bookId);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.insertBook(book) > 0 ? true : false;
    }

    @Override
    public boolean modifyBook(Book book) {
        return bookDao.updateBook(book) > 0 ? true : false;
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBook(id)> 0 ? true : false;
    }
}
