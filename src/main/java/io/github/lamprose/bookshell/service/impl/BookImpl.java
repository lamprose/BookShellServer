package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.BookInfoMapper;
import io.github.lamprose.bookshell.dao.BookMapper;
import io.github.lamprose.bookshell.dao.UserMapper;
import io.github.lamprose.bookshell.domain.Book;
import io.github.lamprose.bookshell.domain.BookInfo;
import io.github.lamprose.bookshell.domain.Comment;
import io.github.lamprose.bookshell.service.BookService;
import io.github.lamprose.bookshell.utils.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BookInfoMapper bookInfoMapper;
    Map<String,Object> map;

    @Override
    public BookInfo getBookInfoByISBN(String isbn) {
        return null;
    }

    @Override
    public List<Book> getUserShelfBook(int id) {
        return bookMapper.getUserShelfBook(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean lendBook(String userName, int bookId) {
        int userId=(int)userMapper.getInfo(userName).get("id");
        return bookMapper.updateIsLend(userId,bookId)>0&&bookMapper.insertHireLend(userName,bookId,new Date(System.currentTimeMillis()))>0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean returnBook(String userName, int bookId) {
        return bookMapper.updateIsLend(0,bookId)>0&&bookMapper.insertHireReturn(userName,bookId,new Date(System.currentTimeMillis()))>0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean postBook(Book book) {
        Map<String ,Object> map=new HashMap<>();
        book.setId(bookMapper.countBook()+1);
        return bookInfoMapper.insertBookInfo(new BookInfo(book.getISBN()))>0&&bookMapper.insertBook(book)>=0;

    }
}
