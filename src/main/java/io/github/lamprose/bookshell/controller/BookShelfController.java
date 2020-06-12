package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.service.BookService;
import io.github.lamprose.bookshell.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping(value = "/bookshelf")
@Controller
public class BookShelfController extends BaseController {

    @Autowired
    BookShelfService bookShelfService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserShelfBook(@PathVariable("id") String idStr){
        int id=-1;
        System.out.println(idStr);
        try{
            id=Integer.parseInt(idStr);
        }catch (Exception ignored){}
        return handleResult(bookService.getUserShelfBook(id));
    }
}
