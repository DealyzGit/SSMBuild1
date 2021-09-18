package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println("addBook->"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println("toUpdateBook"+books);
        model.addAttribute("book",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        System.err.println(books);
        model.addAttribute("list",list);
        return "allBook";
    }


    @RequestMapping("/queryBookByPublish")
    public String queryBookByPublish(String queryBookByPublish,Model model){
        Books books = bookService.queryBookByPublish(queryBookByPublish);
        List<Books> booksList = new ArrayList<>();
        booksList.add(books);
        if (books==null){
            booksList=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        System.err.println(books);
        model.addAttribute("list",booksList);
        return "allBook";
    }

    @RequestMapping("/queryBookByAuthor")
    public String queryBookByAuthor(String queryBookByAuthor,Model model){
        Books books = bookService.queryBookByAuthor(queryBookByAuthor);
        List<Books> booksList = new ArrayList<>();
        booksList.add(books);
        if (books==null){
            booksList=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        System.err.println(books);
        model.addAttribute("list",booksList);
        return "allBook";
    }
}
