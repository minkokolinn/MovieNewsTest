package com.example.admin.movieapp.networks;

import com.example.admin.movieapp.models.Movie;
import com.example.admin.movieapp.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Admin on 9/21/2018.
 */

public interface ApiService {
    @GET(AppConstants.MOVIE_URL)
    Call<Movie> getMovie();
}
