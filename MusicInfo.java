package com.example.nathaniel.musicsqlite.Muisc;

/**
 * Created by Nathaniel on 2018/6/2.
 */

class MusicInfo {
    private String Singer;
    private String Songs;

    public MusicInfo(String songs, String singer) {
        Singer = singer;
        Songs = songs;
    }

    public MusicInfo() {
        super();
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public String getSongs() {
        return Songs;
    }

    public void setSongs(String songs) {
        Songs = songs;
    }

    @Override
    public String toString() {
        return Songs + ',' + Singer + ',' ;
    }
}
