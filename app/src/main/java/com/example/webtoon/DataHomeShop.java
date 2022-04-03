package com.example.webtoon;

public class DataHomeShop {
    private String src;
    private String title;
    private String price;
    private String link;

    public DataHomeShop(){}

    public DataHomeShop(String src, String title, String price, String link) {
        this.src = src;
        this.title = title;
        this.price = price;
        this.link = link;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
