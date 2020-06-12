package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user",produces = { "application/json;charset=UTF-8"})
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String,String> params, HttpServletResponse response){
        return userService.login(params);
    }

    @RequestMapping(value = "/get/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserInfo(@PathVariable("userName") String userName){
        return handleResult(userService.getUserInfo(userName));
    }
}
