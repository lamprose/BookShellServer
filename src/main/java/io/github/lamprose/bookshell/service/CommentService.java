package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.Comment;

import java.util.Map;

public interface CommentService {

    Map<String,Object> postComment(Comment comment);

    Map<String,Object> getCommentByPage(int handwritingId,int page);

}
