package com.example.webtoon;

public class DataWebtoon implements Comparable<DataWebtoon>{
    private String src;
    private String title;
    private String artist;
    private String genre;
    private String group;
    private int age;
    private int freedate;
    private int view;
    private boolean event;
    private String[] tag;
    private String duswo;

    public DataWebtoon() {}

    public DataWebtoon(String src, String title, String artist, String genre, String group, int age, int freedate, int view, boolean event, String[] tag, String duswo) {
        this.src = src;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.group = group;
        this.age = age;
        this.freedate = freedate;
        this.view = view;
        this.event = event;
        this.tag = tag;
        this.duswo = duswo;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFreedate() {
        return freedate;
    }

    public void setFreedate(int freedate) {
        this.freedate = freedate;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public String getDuswo() {
        return duswo;
    }

    public void setDuswo(String duswo) {
        this.duswo = duswo;
    }

    @Override
    public int compareTo(DataWebtoon d) {
        if (this.view < d.getView()) {
            return 1;
        } else if (this.view > d.getView()) {
            return -1;
        }
        return 0;
    }
}
