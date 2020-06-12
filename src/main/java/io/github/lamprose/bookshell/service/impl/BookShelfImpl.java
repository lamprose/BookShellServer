package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.BookInfoMapper;
import io.github.lamprose.bookshell.dao.BookShelfMapper;
import io.github.lamprose.bookshell.domain.Book;
import io.github.lamprose.bookshell.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookShelfImpl implements BookShelfService {
    @Autowired
    BookShelfMapper bookShelfMapper;
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public List<Book> getUserShelfBook(int id) {
        List<Book> list=bookShelfMapper.getUserShelfBook(id);
        list.forEach(item->{
            try{
                item.setBookInfo(bookInfoMapper.getBookInfoByISBN(item.getISBN()));
            }catch (Exception e){
                item.setBookInfo(null);
            }
        });
        return list;
    }
}
