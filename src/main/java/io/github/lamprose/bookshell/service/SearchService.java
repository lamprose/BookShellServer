package io.github.lamprose.bookshell.service;

import io.github.lamprose.bookshell.domain.BookShelf;

import java.util.List;

public interface SearchService {
    List<BookShelf> findBookInBookShelf(String key, int cityCode);
}
