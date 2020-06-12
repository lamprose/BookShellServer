package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.Handwriting;

import java.util.HashMap;
import java.util.Map;

public interface HandwritingService {
    Map<String,Object> getHandwritingByPage(String username,int bookId,int page,String isbn);

    Map<String,Object> postHandwriting(Handwriting handwriting);

    HashMap<String,Object> getById(String id);

    boolean deleteHandwriting(int id);
}
