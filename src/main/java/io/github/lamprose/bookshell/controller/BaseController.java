package io.github.lamprose.bookshell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseController {
    Map<String,Object> handleResult(Object object){
        Map<String,Object> map=new HashMap<>();
        if(object == null||(object instanceof List<?> && ((List<?>) object).size()<=0)){
            map.put("errorCode",1);
            map.put("errorMsg","");
            map.put("data",null);
        }
        else{
            map.putIfAbsent("errorCode",0);
            map.putIfAbsent("errorMsg", "");
            map.putIfAbsent("data",object);
        }
        return map;
    }
}
