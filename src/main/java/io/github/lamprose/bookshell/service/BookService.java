package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.Book;
import io.github.lamprose.bookshell.domain.BookInfo;
import io.github.lamprose.bookshell.domain.Comment;

import java.util.List;
import java.util.Map;

public interface BookService {
    BookInfo getBookInfoByISBN(String isbn);
    List<Book> getUserShelfBook(int id);
    Boolean lendBook(String userName,int bookId);
    Boolean returnBook(String userName,int bookId);
    Boolean postBook(Book book);
}
