package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Rope
 * @Date 2020/7/12 2:52
 * @Version 1.0
 */
@Controller
@RequestMapping("book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")  //选择要注入的接口实现
    private BookService bookService;

    //查询全部的书籍 并且返回一个书籍展示页面
    @RequestMapping("allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);

        return "allBook";
    }
}
