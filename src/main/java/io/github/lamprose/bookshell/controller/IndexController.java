package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    private final static Logger log= LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    @ResponseBody
    public Map<String,String> index(HttpServletRequest request){
        Map<String, String> map= new HashMap<>();
        map.put("id","123");
        map.put("name","456");
        return map;
    }

}
