package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Ad_Activity;
import com.example.test.Advertisement;
import com.example.test.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>{

    private Context myContext;
    private List<Advertisement> myData;

    public RecyclerViewAdapter(Context myContext, List<Advertisement> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.cardview_item_ad, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.ad_title_tv.setText(myData.get(position).getAd_Title());
        holder.book_thumbnail_img.setImageResource(myData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(myContext, Ad_Activity.class);

                //Passes data to the ad activity
                intent.putExtra("Ad Title", myData.get(position).getAd_Title());
                intent.putExtra("Category", myData.get(position).getCategory());
                intent.putExtra("Ad Body", myData.get(position).getAd_Body());
                intent.putExtra("Thumbnail", myData.get(position).getThumbnail());

                //Begin the activity on click
                myContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView ad_title_tv;
        ImageView book_thumbnail_img;
        CardView cardView;

        public myViewHolder(View itemView){
            super(itemView);

            ad_title_tv = (TextView) itemView.findViewById(R.id.ad_title_id);
            book_thumbnail_img = (ImageView) itemView.findViewById(R.id.ad_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}

