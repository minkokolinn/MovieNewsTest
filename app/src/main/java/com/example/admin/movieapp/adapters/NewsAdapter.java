package com.example.admin.movieapp.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.movieapp.R;
import com.example.admin.movieapp.delegate.NewsDelegate;
import com.example.admin.movieapp.models.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 9/19/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    Context ctxt;
    List<Items> items;
    NewsDelegate delegate;

    public NewsAdapter(Context ctxt, List<Items> items,NewsDelegate delegate) {
        this.ctxt = ctxt;
        this.items = items;
        this.delegate=delegate;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ctxt);
        View v=li.inflate(R.layout.sample_view,parent,false);
        NewsHolder nh=new NewsHolder(v);
        return nh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Items i=items.get(position);
        holder.tvTitle.setText(i.getTitle());
        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.N) {
            holder.tvContent.setText(Html.fromHtml(i.getContent(), Html.FROM_HTML_MODE_COMPACT));
        }else{
            holder.tvContent.setText(Html.fromHtml(i.getContent()));
        }

        Picasso.with(ctxt).load(i.getEnclosure().getLink()).placeholder(R.drawable.ic_launcher_background).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvContent;
        ImageView iv;
        public NewsHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.img_sv);
            tvTitle=itemView.findViewById(R.id.tv_title_sv);
            tvContent=itemView.findViewById(R.id.tv_content_sv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delegate.onNewsClick(items.get(getAdapterPosition()));
                }
            });
        }
    }
}
