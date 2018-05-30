package com.sbda.gamal.musicalapp;

import android.widget.ImageView;

public class Song {
    private String ID;
    private String name;
    private String artist;
    private String duration;
    private int image;
    private static int autoIncrementID=0;
    

    public Song(String name, String artist, String duration, int image) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.image = image;
        this.ID=autoIncrementID+"";
        autoIncrementID++;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public int getImage() {
        return image;
    }
}
