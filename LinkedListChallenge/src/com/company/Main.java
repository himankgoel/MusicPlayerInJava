package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Deluxe" , "Ed Sheeren");
        album.addSong("Eraser" , 340);
        album.addSong("Castle on the hill" , 331);
        album.addSong("Dive" , 210);
        album.addSong("Shape of you" , 322);
        album.addSong("Perfect" , 433);
        albums.add(album);

        album = new Album("Illuminate", "Shawn Mendes");
        album.addSong("Ruin" , 339);
        album.addSong("Mercy" , 531);
        album.addSong("Treat you better" , 340);
        album.addSong("Like this" , 420);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(1).addSongToPlaylist("Ruin" , playlist);
        albums.get(0).addSongToPlaylist("Eraser" , playlist);
        albums.get(0).addSongToPlaylist("Dive" , playlist);
        albums.get(0).addSongToPlaylist("Perfect" , playlist);
        albums.get(1).addSongToPlaylist(3 , playlist);
        albums.get(1).addSongToPlaylist("Mercy" , playlist);

        play(playlist);

    }

    private static void play(LinkedList playlist){
        ListIterator<Song> songPlayer = playlist.listIterator();
        if(playlist.isEmpty()){
            System.out.println("Playlist is empty!");
            return;
        }else{
            System.out.println("Now playing " + songPlayer.next().toString());
            printMenu();
        }
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;
        while(true){
            int action = scanner.nextInt();
            switch(action){
                case 0 :
                    System.out.println("Playlist completed");
                    return;
                case 1 :
                    //GOING FORWARD
                    if(!goingForward){
                        if(songPlayer.hasNext()){
                            songPlayer.next();
                        }
                        goingForward = true;
                    }
                    if(songPlayer.hasNext()) {
                        System.out.println("Now playing " + songPlayer.next().toString());
                    }else {
                        System.out.println("This is the last song.");
                    }
                    break;
                case 2:
                    //GOING TO PREVIOUS
                    if(goingForward){
                        if(songPlayer.hasPrevious()){
                            songPlayer.previous();
                        }
                        goingForward = false;
                    }
                    if(songPlayer.hasPrevious()) {
                        System.out.println("Now playing " + songPlayer.previous().toString());
                    }else{
                        System.out.println("This is the first song.");
                    }
                    break;
                case 3 :
                    displayPlaylist(playlist);
                    break;
                case 4:
                    if(playlist.size() < 0){
                        System.out.println("Playlist empty. No song to delete.");
                    }else {
                        songPlayer.remove();
                        if(songPlayer.hasNext()){
                            System.out.println("Now playing " + songPlayer.next().toString());
                        }else if(songPlayer.hasPrevious()){
                            System.out.println("Now playing" + songPlayer.previous().toString());
                        }else{
                            System.out.println("All song removed from playlist.");
                        }
                    }
                    break;
                case 5 :
                    printMenu();
                    break;
                case 6 :
                    System.out.println("Exiting....");
                    return;


            }
        }
    }

    //PRINTING MENU
    private static void printMenu(){
        System.out.println("Enter choice:\n" +
                            "1.Next Song\n" +
                            "2.Previous Song\n" +
                            "3.Print Playlist\n" +
                            "4.Remove current song from playlist\n" +
                            "5.Print menu\n" +
                            "6.Exit of Song Player.");
    }

    //PRINTING PLAYLIST
    private static void displayPlaylist(LinkedList playlist){
        ListIterator<Song> displayList = playlist.listIterator();
        if(displayList.hasNext()){
            System.out.println("############################");
            System.out.println("Songs in playlist:");

        }else{
            System.out.println("Playlist empty.");
            return;
        }
        while(displayList.hasNext()){
            System.out.println(displayList.next().toString());
        }
        System.out.println("############################");
    }
}
