package com.example.calvi.joinmusicplayer;

public class DataModel {
    public String title;
    public String duration;
    public String artist;
    public String album;
    public String url;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDuration() { return duration; }

    public String getArtist() { return artist; }

    public String getUrl() { return url; }

    public String getAlbum() { return album; }

    public void setDuration(String duration) { this.duration = duration; }

    public void setArtist(String artist) { this.artist = artist; }

    public void setAlbum(String album) { this.album = album; }

    public void setUrl(String url) {this.url = url; }
}
