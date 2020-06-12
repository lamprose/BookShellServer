package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.Book;

import java.util.List;

public interface BookShelfService {
    List<Book> getUserShelfBook(int id);
}
