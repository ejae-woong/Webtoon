package com.example.webtoon;

public class DataHomebanner {
    private String src;
    private String link;

    public DataHomebanner(){}

    public DataHomebanner(String src, String link) {
        this.src = src;
        this.link = link;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
