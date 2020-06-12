package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.Handwriting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface HandwritingMapper {
    List<HashMap<String, Object>> getHandwritingByPage(@Param("username") String username, @Param("bookId") int booId, @Param("page") int page, @Param("isbn") String isbn);

    int getByPageCount(@Param("username") String username, @Param("bookId") int booId, @Param("page") int page, @Param("isbn") String isbn);

    HashMap<String,Object> getById(@Param("id") String id);

    int insertHandwriting(Handwriting handwriting);
}
