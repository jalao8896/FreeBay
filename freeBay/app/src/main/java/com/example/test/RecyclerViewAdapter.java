package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>{

    private Context myContext;
    private List<listingObjects> myData;

    public RecyclerViewAdapter(Context myContext, List<listingObjects> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.listings_cardview, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.name.setText(myData.get(position).getItemName());
        Glide.with(myContext).load(myData.get(position).getImg()).into(holder.image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(myContext, listings.class);

                //Passes data to listings
                intent.putExtra("Listing Name", myData.get(position).getItemName());
                intent.putExtra("Listing Condition", myData.get(position).getItemCondition());
                intent.putExtra("Listing Description", myData.get(position).getItemDescription());
                intent.putExtra("Listing Contact Information", myData.get(position).getContactInfo());
                intent.putExtra("Listing Image", myData.get(position).getImg());

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

        TextView name;
        ImageView image;
        CardView cardView;

        public myViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listingNameCard);
            image = itemView.findViewById(R.id.listingImageCard);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }
}
