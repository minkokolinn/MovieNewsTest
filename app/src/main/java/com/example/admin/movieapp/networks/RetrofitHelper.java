package com.example.admin.movieapp.networks;

import com.example.admin.movieapp.delegate.MovieDelegate;
import com.example.admin.movieapp.models.Movie;
import com.example.admin.movieapp.utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 9/21/2018.
 */

public class RetrofitHelper {
    private static RetrofitHelper INS;

    public static RetrofitHelper getINS(){
        if(INS==null){
            INS=new RetrofitHelper();
        }
        return INS;
    }

    ApiService api;
    private RetrofitHelper(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(ApiService.class);
    }

    public void getMovieNews(final MovieDelegate delegate){
        api.getMovie().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                delegate.getData(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                delegate.getError(t.getMessage());
            }
        });
    }
}
