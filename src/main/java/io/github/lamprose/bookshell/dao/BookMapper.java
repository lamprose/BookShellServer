package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    Book getBookById(@Param("id") String id);

    List<Book> getUserShelfBook(@Param("id") int id);

    int insertHireLend(@Param("userName") String userName, @Param("bookId") int bookId, @Param("time") Date time);

    int insertHireReturn(@Param("userName") String userName,@Param("bookId") int bookId,@Param("time") Date time);

    int updateIsLend(@Param("isLend") int isLend,@Param("bookId") int boolId);

    int insertBook(Book book);

    int countBook();
}
