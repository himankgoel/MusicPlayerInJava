package com.company;

public class Song {
    private String title;
    private int durationInSec;

    public Song(String title, int durationInSec) {
        this.title = title;
        this.durationInSec = durationInSec;
    }

    //GETTERS SETTERS
    public String getTitle() {
        return title;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.durationInSec;
    }
}