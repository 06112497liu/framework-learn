package com.lwb.Study.lambda.day01.day02;

import java.util.List;

/**
 * 专辑类
 */
public class Album {

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 专辑的曲目
     */
    private List<Track> tracks;

    /**
     * 创作专辑的艺术家列表
     */
    private List<Album> albums;

    public Album() {
    }

    public Album(String name, List<Track> tracks, List<Album> albums) {
        this.name = name;
        this.tracks = tracks;
        this.albums = albums;
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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
