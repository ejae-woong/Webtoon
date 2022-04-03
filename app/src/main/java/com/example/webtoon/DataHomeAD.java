package com.example.webtoon;

public class DataHomeAD {
    private String title;
    private String src;

    public DataHomeAD(){}

    public DataHomeAD(String title, String src) {
        this.title = title;
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
