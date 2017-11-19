package pl.legalnyplener.POSTERRA;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyPosterAdapter extends RecyclerView.Adapter {

    Context context;

    private ArrayList<Poster> posters = new ArrayList<>();
    private RecyclerView recyclerView;


    private class MyPosterViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterImage;

        public MyPosterViewHolder(View itemView) {
            super(itemView);
            posterImage = (ImageView) itemView.findViewById(R.id.ImgPoster);
        }
    }

    public MyPosterAdapter(Context cont, ArrayList<Poster> posterList, RecyclerView recyclerview){
        context = cont;
        posters = posterList;
        recyclerView = recyclerview;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_layout, parent, false);
        return new MyPosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Poster poster = posters.get(position);
        Picasso.with(context).load(String.valueOf(poster.get_imgURL())).error(R.drawable.picklerick_error).into(((MyPosterViewHolder) holder).posterImage);

        ((MyPosterViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFragment(poster);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posters.size();
    }

    public void GoToFragment(Poster poster){
        Fragment fragment = new PosterFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", poster.get_name());
        bundle.putString("INFO", poster.get_info());
        bundle.putString("CITY", poster.get_city());
        bundle.putString("ADDRESS", poster.get_adress());
        bundle.putString("START_DATE", poster.get_start_date());
        bundle.putString("END_DATE", poster.get_end_date());
        bundle.putString("START_TIME", poster.get_start_time());
        bundle.putString("END_TIME", poster.get_end_time());
        bundle.putString("IMG_URL", poster.get_imgURL());
        bundle.putString("INFO_URL", poster.get_infoURL());
        bundle.putString("FACEBOOK_URL", poster.get_facebookURL());
        bundle.putString("TICKET_URL", poster.get_ticketURL());
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
