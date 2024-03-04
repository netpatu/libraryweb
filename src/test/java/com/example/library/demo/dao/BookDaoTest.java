package com.example.library.demo.dao;

import com.example.library.demo.entity.Book;
import com.example.library.demo.utils.DateUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class BookDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private BookDao bookDao;

    @Test
    public void testCreateTable() {
        bookDao.createTable("tb_book");
    }

    @Test
    public void testInsertBooks() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book(
                "Time of shit1",
                "首席执行官",
                new java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#1");
        Book book2 = new Book(
                "Time of shit2",
                "首席执行官",
                new java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#2");
        Book book3 = new Book(
                "Time of shit3",
                "首席执行官",
                new java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#3");
        Book book4 = new Book(
                "Time of shit4",
                "首席执行官",
                new java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#4");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        int effectedNum = 0;
        for (int i = 0; i < books.size(); i++) {
            effectedNum += bookDao.insertBook(books.get(i));
            System.out.println("effectedNum = " + effectedNum);
        }
        //检测影响行数
        assertEquals(4, effectedNum);
    }

    @Test
    public void testGetBooks() {
        List<Book> books = bookDao.queryBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).toString());
        }
        System.out.print("\n");
    }

    @Test
    public void testGetBookById() {
        Book book = bookDao.queryBookById(-1755955764);
        System.out.print(book.toString());
        System.out.print("\n");
    }

    @Test
    public void testGetLimitedBooks() {
        Map<String, Integer> params = new HashMap();
        params.put("limit", 10);
        params.put("offset", 0);
        List<Book> books = bookDao.queryBookLimit(params);
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).toString());
        }
        System.out.print("\n");
    }

    @Test
    public void testUpdateBook() {
        Book book1 = new Book(-1755955764,
                "34232|3333",
                "xx444X3333",
                new java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#1");
        bookDao.updateBook(book1);
    }

    @Test
    public void deleteData() {
        bookDao.deleteBook(0);
    }

    @Test
    public void dropTable() {
        bookDao.dropBook();
    }
}
