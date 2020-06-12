package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.domain.Book;
import io.github.lamprose.bookshell.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/search",produces = { "application/json;charset=UTF-8"})
public class SearchController extends BaseController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/book/{key}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> login(@PathVariable String key,@RequestParam(value = "cityCode",required = false) String cityCode){
        System.out.println(key);
        int cityCodeInt=-1;
        try{
            cityCodeInt=Integer.parseInt(cityCode);
        }catch (Exception e){

        }
        return handleResult(searchService.findBookInBookShelf(key,cityCodeInt));
    }
}
