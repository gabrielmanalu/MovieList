package com.example.movielist.Network;

import com.example.movielist.Model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("8Z8Q")
    Call<List<MovieModel>> getMovieList();
}
