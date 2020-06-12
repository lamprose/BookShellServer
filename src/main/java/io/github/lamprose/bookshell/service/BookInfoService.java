package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.BookInfo;

public interface BookInfoService extends BaseService {
    BookInfo getBookInfoByISBN(String isbn);

    BookInfo getBookInfoByISBNOrId(String isbn,int bookId);
}
