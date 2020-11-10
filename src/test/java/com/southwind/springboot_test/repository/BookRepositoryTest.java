package com.southwind.springboot_test.repository;

import com.southwind.springboot_test.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        List<Book> all = bookRepository.findAll();

        for (Book book : all) {
            System.out.println(book);
        }

    }

    void Save(){
        Book book = new Book();
        book.setName("红楼梦");
        book.setAuthor("额是那傻逼");
        System.out.println(bookRepository.save(book));

    }

    void ById(){
        Optional<Book> book = bookRepository.findById(1);
        // 判断Book对象是否为null
        System.out.println(book.isPresent());
    }


    void update(){
        Book book = new Book();
        book.setId(119);
        book.setName("红楼梦");
        book.setAuthor("额是那傻逼2");
        System.out.println(bookRepository.save(book));
    }


    void delete(){
        bookRepository.deleteById(122);
    }

}