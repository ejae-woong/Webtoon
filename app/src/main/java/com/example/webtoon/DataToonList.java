package com.example.webtoon;

public class DataToonList {
    private String src;
    private String title;
    private String genre;

    public DataToonList(){}

    public DataToonList(String src, String title, String genre) {
        this.src = src;
        this.title = title;
        this.genre = genre;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
