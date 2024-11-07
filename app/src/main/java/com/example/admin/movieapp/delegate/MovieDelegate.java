package com.example.admin.movieapp.delegate;

import com.example.admin.movieapp.models.Movie;

/**
 * Created by Admin on 9/21/2018.
 */

public interface MovieDelegate {
    public void getData(Movie movie);
    public void getError(String str);
}
