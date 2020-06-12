package io.github.lamprose.bookshell.dao;

import io.github.lamprose.bookshell.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    List<HashMap<String, Object>> getCommentByPage(@Param("handwritingId") int handwritingId, @Param("page") int page);

    int getByPageCount(@Param("handwritingId") int hanwritingId, @Param("page") int page);

    int insertComment(Comment comment);
}
