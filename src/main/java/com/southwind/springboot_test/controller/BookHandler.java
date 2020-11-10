package com.southwind.springboot_test.controller;

import com.southwind.springboot_test.entity.Book;
import com.southwind.springboot_test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName：BookHandler
 * @Description：TODO
 * @Author：HuangZhen
 * @Date 2020/9/13 18:46
 * @Versopn：1.0
 */

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 查询所有数据
     * @return 返回List集合
     */
    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return 返回Page<Book>分页集合
     */
    @GetMapping("/findAllPage/{page}/{size}")
    public Page<Book> findAllPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        // Pageable 导入 org.springframework.data.domain.Pageable 这个包
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    /**
     * 添加图书
     * @param book
     * @return 返回success或error  判断是否成功
     */
    @PostMapping("/save")
    /* 因为是json格式传过来的 所以需要加上@RequestBody 映射来转成 java对象 */
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    /**
     *  根据id查询
     * @param id
     * @return 返回Book图书对象
     */
    @GetMapping("findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        Optional<Book> byId = bookRepository.findById(id);
        // byId.isPresent() 判断Book对象是否为null
        return byId.isPresent()?byId.get():null;
    }

    /**
     *  修改
     * @param book
     * @return 返回success或error  判断是否成功
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 根据id删除
     * @param id
     */
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
