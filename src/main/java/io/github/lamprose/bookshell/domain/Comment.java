package io.github.lamprose.bookshell.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Comment {
    private int id;
    private String content;
    private int handwritingId;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHandwritingId() {
        return handwritingId;
    }

    public void setHandwritingId(int handwritingId) {
        this.handwritingId = handwritingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
