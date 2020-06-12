package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookShelfMapper {
    List<Book> getUserShelfBook(@Param("id") int id);
}
