package com.example.webtoon;

public class DataHomebanner {
    private String src;
    private DataWebtoon webtoon;

    public DataHomebanner(){}

    public DataHomebanner(String src, DataWebtoon webtoon) {
        this.src = src;
        this.webtoon = webtoon;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public DataWebtoon getWebtoon() {
        return webtoon;
    }

    public void setWebtoon(DataWebtoon webtoon) {
        this.webtoon = webtoon;
    }
}
