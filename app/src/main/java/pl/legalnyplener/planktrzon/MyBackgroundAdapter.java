package pl.legalnyplener.planktrzon;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


public class MyBackgroundAdapter extends RecyclerView.Adapter{
    Context context;

    private String url = "http://plakat.legalnyplener.pl/SiiHackaton/background/pic_";
    private RecyclerView recyclerView;
    public Random generator = new Random();

    private class MyBackgroundViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public MyBackgroundViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.Imgbackground);
        }
    }

    public MyBackgroundAdapter(Context cont, RecyclerView recyclerview){
        context = cont;
        recyclerView = recyclerview;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.background_poster_item, parent, false);
        return new MyBackgroundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String random = String.valueOf(generator.nextInt(269));
        if(random.length()<3){
            random = "0"+random;
        }
        String temp = url + random + ".jpg";
        Picasso.with(context).load(temp).error(R.drawable.error_bg).into(((MyBackgroundViewHolder) holder).image);
    }

    @Override
    public int getItemCount() {
        return 52;
    }


}
