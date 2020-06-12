package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.domain.Book;
import io.github.lamprose.bookshell.domain.BookInfo;
import io.github.lamprose.bookshell.domain.Comment;
import io.github.lamprose.bookshell.service.BookInfoService;
import io.github.lamprose.bookshell.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/book")
@Controller
public class BookController extends BaseController {

    @Autowired
    BookInfoService bookInfoService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/isbn/{isbn}",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getBookInfoByISBN(@PathVariable String isbn){
        return handleResult(bookInfoService.getBookInfoByISBN(isbn));
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getBookInfo(@RequestParam(value = "ISBN",required = false) String isbn,@RequestParam(value = "bookId",required = false) String bookIdStr){
        int bookId=-1;
        try {
            bookId=Integer.parseInt(bookIdStr);
        }catch (Exception ignored){}
        return handleResult(bookInfoService.getBookInfoByISBNOrId(isbn,bookId));
    }

    @RequestMapping(value = "/lend",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> lendBook(@RequestParam(value = "userName") String userName,@RequestParam(value = "bookId") String bookIdStr){
        int bookId=-1;
        try {
            bookId=Integer.parseInt(bookIdStr);
        }catch (Exception ignored){}
        return handleResult(bookService.lendBook(userName,bookId));
    }

    @RequestMapping(value = "/return",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> returnBook(@RequestParam(value = "userName") String userName,@RequestParam(value = "bookId") String bookIdStr){
        int bookId=-1;
        try {
            bookId=Integer.parseInt(bookIdStr);
        }catch (Exception ignored){}
        return handleResult(bookService.returnBook(userName,bookId));
    }

    @RequestMapping(value = "post",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postBook(@RequestBody Book book){
        return handleResult(bookService.postBook(book));
    }
}
