package io.github.lamprose.bookshell.controller;

import io.github.lamprose.bookshell.domain.Comment;
import io.github.lamprose.bookshell.domain.Handwriting;
import io.github.lamprose.bookshell.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/comment",produces = { "application/json;charset=UTF-8"})
public class CommentController extends BaseController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "post",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> postComment(@RequestBody Comment comment){
        return handleResult(commentService.postComment(comment));
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCommentByPage(@PathVariable("id") String handwritingId,@RequestParam("page") String page){
        int handwritingIdInt=-1,pageInt=-1;
        try{
            pageInt=Integer.parseInt(page);
            handwritingIdInt=Integer.parseInt(handwritingId);
        }catch (Exception e){
//            e.printStackTrace();
        }
        return handleResult(commentService.getCommentByPage(handwritingIdInt,pageInt));
    }
}
