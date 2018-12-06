package com.example.calvi.joinmusicplayer;

public class User {

    private int id;
    private String nrp, nama, email;

    public User(int id, String nrp, String nama, String email) {
        this.id = id;
        this.nrp = nrp;
        this.nama = nama;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNrp() {
        return nrp;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }
}
