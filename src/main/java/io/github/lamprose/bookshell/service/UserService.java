package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    Map<String,Object> login(Map<String,String> params);

    HashMap<String,Object> getUserInfo(String userName);

    boolean checkUsername(String username);

    boolean register(String username,String password);
}