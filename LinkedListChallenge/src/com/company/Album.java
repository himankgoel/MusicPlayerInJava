package com.company;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    //CONSTRUCTOR
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    //ADDING SONG TO THE ALBUM
    public boolean addSong(String title , int durationInSec){
        if(findSong(title) == null){
            Song song = new Song(title , durationInSec);
            this.songs.add(song);
            return true;
        }
        return false;
    }
    //CHECKING FOR IF SONG ALREADY EXISTS
    private Song findSong(String title){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    //ADDING SONGS TO PLAYLIST FROM THIS ALBUM
    //TRACK NUMBER
    public boolean addSongToPlaylist(int trackNumber , LinkedList playlist){
        int index = trackNumber - 1;
        if((index >= 0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("ERROR : Track Number " + index + " not valid");
        return false;
    }
    //SONG TITLE
    public boolean addSongToPlaylist(String title , LinkedList playlist){
        Song checkedSong = findSong(title);
       if(checkedSong != null){
           playlist.add(checkedSong);
           return true;
       }
        System.out.println("Song " + title + "doesn't exists!");
       return false;
    }
}
