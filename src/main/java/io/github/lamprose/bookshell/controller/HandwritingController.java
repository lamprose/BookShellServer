package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.domain.Handwriting;
import io.github.lamprose.bookshell.service.HandwritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/handwriting",produces = { "application/json;charset=UTF-8"})
public class HandwritingController extends BaseController {

    @Autowired
    HandwritingService handwritingService;

    /**
     * 分页获取笔迹
     * @param page 页数
     * @return 返回结果
     */
    @RequestMapping(value = "/{username}/json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHandwritingByPage(@PathVariable("username") String username, @RequestParam("page") String page, @RequestParam(value = "bookId", required = false) String bookId, @RequestParam(value = "isbn", required = false) String isbn){
        int bookIdInt=-1,pageInt=-1;
        try{
            pageInt=Integer.parseInt(page);
            bookIdInt=Integer.parseInt(bookId);
        }catch (Exception e){
//            e.printStackTrace();
        }
        return handleResult(handwritingService.getHandwritingByPage(username,bookIdInt,pageInt,isbn));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHandwritingById(HttpServletRequest request, @PathVariable String id){
        return handleResult(handwritingService.getById(id));
    }

    /**
     * 发布笔迹
     * @param handwriting 前端传来的笔迹参数
     * @return 返回是否存储发布成功
     */

    @RequestMapping(value = "post",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postHandwriting(@RequestBody Handwriting handwriting){
        return handleResult(handwritingService.postHandwriting(handwriting));
    }

    @RequestMapping(value = "deleteHandWriting",method = RequestMethod.POST)
    public boolean deleteHandWriting(@RequestBody Map<String,String> params){
        String handWritingId=params.get("id");
        return handwritingService.deleteHandwriting(Integer.parseInt(handWritingId));
    }
}
