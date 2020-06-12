package io.github.lamprose.bookshell.domain;

import java.util.HashMap;
import java.util.List;

public class BookShelf {
    private int id;
    private int cityCode;
    private Double latitude;
    private Double longitude;
    private List<HashMap<String,Object>> bookList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<HashMap<String, Object>> getBookList() {
        return bookList;
    }

    public void setBookList(List<HashMap<String, Object>> bookList) {
        this.bookList = bookList;
    }
}
