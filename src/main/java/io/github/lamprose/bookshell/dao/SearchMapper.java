package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.BookShelf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface SearchMapper {
    List<HashMap<String,Object>> searchBookInBookShelf(@Param("key") String key, @Param("cityCode") int cityCode,@Param("bookShelfId") int bookShelfId);

    List<BookShelf> searchBookShelf(@Param("key") String key, @Param("cityCode") int cityCode);
}
