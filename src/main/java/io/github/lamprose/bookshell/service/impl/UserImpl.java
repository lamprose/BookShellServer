package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.UserMapper;
import io.github.lamprose.bookshell.domain.User;
import io.github.lamprose.bookshell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> login(Map<String,String> params) {
        Map<String,Object> map=new HashMap<>();
        User user=userMapper.findByUserName(params.get("userName"));
        if(user==null){
            map.put("errorCode",2);
            map.put("errorMsg","用户名不存在");
            map.put("data", new User());
        }else{
            if(user.getPassword().equals(params.get("password"))){
                map.put("errorCode",0);
                map.put("data",user);
                map.put("errorMsg","");
            }else{
                map.put("errorCode",1);
                map.put("errorMsg","密码错误");
                map.put("data",user);
            }
        }
        return map;
    }

    @Override
    public HashMap<String, Object> getUserInfo(String userName) {
        return userMapper.getInfo(userName);
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}
