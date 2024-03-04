package com.example.library.demo.dao;

import com.example.library.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BookDao {

    /**
     * create table
     *
     * @param tableName
     */
    void createTable(@Param("tableName") String tableName);

    /**
     * get all books
     *
     * @return book List
     */
    List<Book> queryBooks();

    /**
     * get books in a range
     *
     * @return areaList
     */
    List<Book> queryBookLimit(Map<String, Integer> parameter);

    /**
     * query book by id
     *
     * @return Book
     */
    Book queryBookById(int BookId);

    /**
     * insert a new book
     *
     * @param book
     * @return
     */
    int insertBook(Book book);

    /**
     * update a book
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * delete a book
     *
     * @param bookId
     * @return
     */
    int deleteBook(int bookId);

    void dropBook();
}
