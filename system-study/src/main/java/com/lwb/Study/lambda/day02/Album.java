package com.lwb.Study.lambda.day02;

import java.util.List;

/**
 * 专辑类
 */
public class Album {
    private String name; //专辑名称
    private List<Track> tracks; //专辑的曲目
    private Artist artist; // 创作专辑的艺术家

    public Album() {
    }

    public Album(String name, List<Track> tracks, Artist artist) {
        this.name = name;
        this.tracks = tracks;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
