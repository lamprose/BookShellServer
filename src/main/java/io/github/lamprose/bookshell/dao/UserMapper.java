package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface UserMapper {
    User findByUserName(@Param("userName") String userName);

    HashMap<String,Object> getInfo(@Param("userName") String userName);
}
