package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.HandwritingMapper;
import io.github.lamprose.bookshell.domain.Handwriting;
import io.github.lamprose.bookshell.service.HandwritingService;
import io.github.lamprose.bookshell.utils.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HandwritingImpl implements HandwritingService {

    @Autowired
    HandwritingMapper handwritingMapper;

    @Override
    public Map<String, Object> getHandwritingByPage(String username, int bookId, int page, String isbn) {
        Map<String,Object> datas=new HashMap<>();
        List<HashMap<String, Object>> result = handwritingMapper.getHandwritingByPage(username,bookId,page,isbn);
        if(result.size()>0){
            datas.put("curPage",page);
            datas.put("pageCount",(handwritingMapper.getByPageCount(username,bookId,page,isbn)+9)/10);
            datas.put("datas",result);
        }
        return datas;
    }

    @Override
    public Map<String,Object> postHandwriting(Handwriting handwriting) {
        Map<String ,Object> map=new HashMap<>();
        if(handwriting.getTime()==null){
            handwriting.setTime(new Date(System.currentTimeMillis()));
        }
        if(handwritingMapper.insertHandwriting(handwriting)>=0){
            map.put("errorCode",0);
        }else{
            map.put("errorCode",1);
            map.put("errorMsg", ErrorMsg.INSERT_ERROR);
        }
        return map;
    }

    @Override
    public HashMap<String, Object> getById(String id) {
        return handwritingMapper.getById(id);
    }

    @Override
    public boolean deleteHandwriting(int id) {
        return false;
    }
}
