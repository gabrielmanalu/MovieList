package com.example.movielist.Model;

public class MovieModel {
    private String title;
    private String poster_path;
    private String overview;


    public MovieModel(String title, String image, String overview) {
        this.title = title;
        this.poster_path = image;
        this.overview = overview;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return poster_path;
    }

    public String getSynopsis() {
        return overview;
    }

    public void setSynopsis(String synopsis) {
        this.overview = synopsis;
    }

    public void setImage(String image) {
        this.poster_path = image;
    }
}
