package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.CommentMapper;
import io.github.lamprose.bookshell.domain.Comment;
import io.github.lamprose.bookshell.service.CommentService;
import io.github.lamprose.bookshell.utils.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CommentImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Map<String, Object> postComment(Comment comment) {
        Map<String ,Object> map=new HashMap<>();
        if(comment.getTime()==null){
            comment.setTime(new Date(System.currentTimeMillis()));
        }
        if(commentMapper.insertComment(comment)>=0){
            map.put("errorCode",0);
        }else{
            map.put("errorCode",1);
            map.put("errorMsg", ErrorMsg.INSERT_ERROR);
        }
        return map;
    }

    @Override
    public Map<String, Object> getCommentByPage(int handwritingId, int page) {
        Map<String,Object> datas=new HashMap<>();
        List<HashMap<String, Object>> result = commentMapper.getCommentByPage(handwritingId,page);
        if(result.size()>0){
            datas.put("curPage",page);
            datas.put("pageCount",(commentMapper.getByPageCount(handwritingId,page)+9)/10);
            datas.put("datas",result);
        }
        return datas;
    }
}
