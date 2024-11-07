package com.example.admin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.movieapp.activities.ShowActivity;
import com.example.admin.movieapp.adapters.NewsAdapter;
import com.example.admin.movieapp.delegate.MovieDelegate;
import com.example.admin.movieapp.delegate.NewsDelegate;
import com.example.admin.movieapp.models.Items;
import com.example.admin.movieapp.models.Movie;
import com.example.admin.movieapp.networks.RetrofitHelper;
import com.example.admin.movieapp.utils.Utils;

import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RetrofitHelper rh;
    LinearLayout llInternet;
    Button btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRetry=findViewById(R.id.btn_retry);
        rv=findViewById(R.id.rv_am);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        llInternet=findViewById(R.id.ll_noInternet);

        rh=RetrofitHelper.getINS();

        trytogetData();

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trytogetData();
            }
        });

    }

    public void trytogetData(){
        if(Utils.isInternet(this)){
            rv.setVisibility(View.VISIBLE);
            llInternet.setVisibility(View.GONE);

            rh.getMovieNews(new MovieDelegate() {
                @Override
                public void getData(Movie movie) {
                    List<Items> items=movie.getItems();
                    NewsAdapter adapter=new NewsAdapter(MainActivity.this, items, new NewsDelegate() {
                        @Override
                        public void onNewsClick(Items items) {
                            Intent i1=new Intent(MainActivity.this, ShowActivity.class);
                            Bundle bd1=new Bundle();
                            bd1.putParcelable("item1",items);
                            bd1.putString("image1",items.getEnclosure().getLink());
                            i1.putExtras(bd1);
                            startActivity(i1);
                        }
                    });
                    rv.setAdapter(adapter);
                }

                @Override
                public void getError(String str) {

                }
            });
        }
        else {
            rv.setVisibility(View.GONE);
            llInternet.setVisibility(View.VISIBLE);
        }
    }
}
