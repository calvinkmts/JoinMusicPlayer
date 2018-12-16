package com.example.calvi.joinmusicplayer;

public class DataModel {
    public String title;
    public String image;
    public String artist;
    public String album;
    public String url;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }

    public String getArtist() { return artist; }

    public String getUrl() { return url; }

    public String getAlbum() { return album; }

    public void setImage(String duration) { this.image = duration; }

    public void setArtist(String artist) { this.artist = artist; }

    public void setAlbum(String album) { this.album = album; }

    public void setUrl(String url) {this.url = url; }
}
