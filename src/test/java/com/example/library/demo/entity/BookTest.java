package com.example.library.demo.entity;

import com.example.library.demo.dao.BookDao;
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
public class BookTest {

    @Test
    public void testInsertBooks() {

        Book book1 = new Book(
                "Time of shit1",
                "首席执行官",
                new  java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#1");

//        Book book2 = new Book(1L,
//                "Time of shit1",
//                "首席执行官",
//                new  java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
//                "#%123456789#1");

        Book book2 = new Book(
                "Time of shit2",
                "首席执行官",
                new  java.sql.Date(DateUtil.parseStr2Date("2000-11-11 11:11:11").getTime()),
                "#%123456789#2");

        //检测影响行数
        assertEquals(book1, book2);
    }

}
