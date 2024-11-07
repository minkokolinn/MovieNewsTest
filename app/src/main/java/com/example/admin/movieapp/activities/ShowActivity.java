package com.example.admin.movieapp.activities;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.movieapp.R;
import com.example.admin.movieapp.models.Items;
import com.squareup.picasso.Picasso;

import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;

/**
 * Created by Admin on 9/21/2018.
 */

public class ShowActivity extends AppCompatActivity{
    ImageButton ib;
    ImageView iv;
    TextView tvTitle,tvDate,tvContent;
    Button btnSeeMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        ib=findViewById(R.id.btn_exit_sa);
        iv=findViewById(R.id.img_sa);
        tvTitle=findViewById(R.id.tv_title_sa);
        tvDate=findViewById(R.id.tv_date_sa);
        tvContent=findViewById(R.id.tv_content_sa);
        btnSeeMore=findViewById(R.id.btn_seemore_sa);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent i1=getIntent();
        Bundle bd1=i1.getExtras();
        String img1=bd1.getString("image1");
        final Items items1=bd1.getParcelable("item1");
        tvTitle.setText(items1.getTitle());
        tvDate.setText(items1.getPubDate());
        Picasso.with(this).load(img1).placeholder(R.drawable.ic_arrow_back_black_24dp).into(iv);

        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.N) {
            tvContent.setText(Html.fromHtml(items1.getContent(), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tvContent.setText(Html.fromHtml(items1.getContent()));
        }


        btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                        .addDefaultShareMenuItem()
                        .setToolbarColor(ShowActivity.this.getResources().getColor(R.color.colorPrimary))
                        .setShowTitle(true)
                        .setCloseButtonIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_arrow_back_black_24dp))
                        .build();

// This is optional but recommended
                CustomTabsHelper.addKeepAliveExtra(ShowActivity.this, customTabsIntent.intent);

// This is where the magic happens...
                CustomTabsHelper.openCustomTab(ShowActivity.this, customTabsIntent,
                        Uri.parse(items1.getLink()),
                        new WebViewFallback());
            }
        });
    }
}
