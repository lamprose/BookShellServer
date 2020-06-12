package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.BookInfoMapper;
import io.github.lamprose.bookshell.dao.BookMapper;
import io.github.lamprose.bookshell.domain.BookInfo;
import io.github.lamprose.bookshell.service.BookInfoService;
import io.github.lamprose.bookshell.utils.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class BookInfoImpl implements BookInfoService {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public BookInfo getBookInfoByISBN(String isbn) {
        return bookInfoMapper.getBookInfoByISBN(isbn);

    }

    @Override
    public BookInfo getBookInfoByISBNOrId(String isbn, int bookId) {
        return bookInfoMapper.getBookInfoByISBNOrId(isbn,bookId);
    }
}
