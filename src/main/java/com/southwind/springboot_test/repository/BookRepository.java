package com.southwind.springboot_test.repository;

import com.southwind.springboot_test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName：repository
 * @Description：TODO
 * @Author：HuangZhen
 * @Date 2020/9/13 18:39
 * @Versopn：1.0
 */

public interface BookRepository extends JpaRepository<Book,Integer> {
}
