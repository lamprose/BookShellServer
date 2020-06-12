package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookInfoMapper {
    BookInfo getBookInfoByISBN(@Param("ISBN")String isbn);

    BookInfo getBookInfoByISBNOrId(@Param("ISBN")String isbn,@Param("bookId") int bookId);

    int insertBookInfo(BookInfo bookInfo);
}
