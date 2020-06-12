package io.github.lamprose.bookshell.domain;

public class Book {
    private int id;
    private String ISBN;
    private int bookShelfId;
    private String userName;
    private int isLend;
    private BookInfo bookInfo=null;

    public Book() {
        this.id=-1;
        this.ISBN=null;
        this.bookShelfId=-1;
        this.userName=null;
        this.isLend=-1;
        this.bookInfo=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getBookShelfId() {
        return bookShelfId;
    }

    public void setBookShelfId(int bookShelfId) {
        this.bookShelfId = bookShelfId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsLend() {
        return isLend;
    }

    public void setIsLend(int isLend) {
        this.isLend = isLend;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
