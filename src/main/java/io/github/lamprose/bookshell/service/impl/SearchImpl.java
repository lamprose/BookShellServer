package io.github.lamprose.bookshell.service.impl;

import io.github.lamprose.bookshell.dao.SearchMapper;
import io.github.lamprose.bookshell.domain.BookShelf;
import io.github.lamprose.bookshell.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class SearchImpl implements SearchService {

    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<BookShelf> findBookInBookShelf(String key, int cityCode) {
        List<BookShelf> bookShelves= searchMapper.searchBookShelf(key,cityCode);
        bookShelves.forEach(item->{
            List<HashMap<String,Object>> bookList=searchMapper.searchBookInBookShelf(key,cityCode,item.getId());
            if(bookList.size()>0)
                item.setBookList(bookList);
        });
        return bookShelves;
    }
}
