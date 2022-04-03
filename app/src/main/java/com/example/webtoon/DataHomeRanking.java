package com.example.webtoon;

public class DataHomeRanking implements Comparable<DataHomeRanking>{
    private String src;
    private String title;
    private String artist;
    private String genre;
    private int freedate;
    private int view;
    private boolean event;

    public DataHomeRanking(){}

    public DataHomeRanking(String src, String title, String artist, String genre, int freedate, int view, boolean event) {
        this.src = src;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.freedate = freedate;
        this.view = view;
        this.event = event;
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

    public boolean getEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    @Override
    public int compareTo(DataHomeRanking d) {
        if (this.view < d.getView()) {
            return 1;
        } else if (this.view > d.getView()) {
            return -1;
        }
        return 0;
    }
}
