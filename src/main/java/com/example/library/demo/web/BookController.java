package com.example.library.demo.web;

import com.example.library.demo.entity.Book;
import com.example.library.demo.service.BookService;
import com.example.library.demo.utils.DateUtil;
import com.example.library.demo.web.data.DataContent;
import com.example.library.demo.web.data.ReponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/addbook", method = RequestMethod.POST, consumes = "application/json")
    public ReponseData<DataContent> addBook(@RequestBody Map params) {
        String title = (String) params.get("bookTitle");
        String author = (String) params.get("author");
        String date = (String) params.get("publicationDate");
        String isbn = (String) params.get("isbn");

        Book book = new Book();
        book.setBookTitle(title);
        book.setAuthor(author);
        book.setPublicationDate(new java.sql.Date(DateUtil.parseStr2Date(date).getTime()));
        book.setIsbn(isbn);
        book.setBookId(book.hashCode());

        System.out.println(book.toString());

        boolean status = bookService.addBook(book);
        if (status)
            return new ReponseData<>(200, 1, "insert book success", new DataContent("success"));
        else
            return new ReponseData<>(400, "insert book failed", new DataContent("failed"));
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ReponseData getBooks() {

        List<Book> books = bookService.getBooks();
        if (books.size() > 0) {
            return new ReponseData<List<Book>>(200, 1, "get book success", books);
        }

        return new ReponseData<DataContent>(400, "get book failed", new DataContent("failed"));
    }

    @RequestMapping(value = "/books/{bookid}", method = RequestMethod.GET)
    public ReponseData getBooks(@PathVariable("bookid") int bookid) {
        Book book = bookService.getBookById(bookid);
        if (book == null) {
            return new ReponseData<DataContent>(400, "get book failed", new DataContent("failed"));
        }
        return new ReponseData<Book>(200, 1, "get book success", book);
    }

    @RequestMapping(value = "/updatebook", method = RequestMethod.POST, consumes = "application/json")
    public ReponseData updateBook(@RequestBody Map params) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Book book = objectMapper.convertValue(params, Book.class);

        Book bookValue = new Book((Integer) params.get("bookId"), (String) params.get("bookTitle"),
                (String) params.get("author"),
                new java.sql.Date(DateUtil.parseStr2Date((String) params.get("publicationDate")).getTime()),
                (String) params.get("isbn"));
//        bookValue.setBookId(bookValue.hashCode());

        System.out.println(bookValue.toString());

        boolean status = bookService.modifyBook(bookValue);
        if (status)
            return new ReponseData<>(200, 1, "modify book success", new DataContent("success"));
        else
            return new ReponseData<>(400, "modify book failed", new DataContent("failed"));
    }

    @RequestMapping(value = "/deletebook", method = RequestMethod.POST, consumes = "application/json")
    public ReponseData deleteBook(@RequestBody Map params) {
        System.out.println("deleteBook");
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.convertValue(params, Book.class);
        System.out.println(book.toString());
        boolean status = bookService.deleteBook(book.getBookId());
        if (status)
            return new ReponseData<>(200, 1, "delete book success", new DataContent("success"));
        else
            return new ReponseData<>(400, "delete book failed", new DataContent("failed"));
    }

}
