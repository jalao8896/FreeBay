package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
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
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
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
                intent.putExtra("Listing Email Address", myData.get(position).getEmailInfo());
                intent.putExtra("Listing Phone Number", myData.get(position).getPhoneNumberInfo());
                intent.putExtra("Listing Image", myData.get(position).getImg());
                //Begin the activity on click
                myContext.startActivity(intent);

            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseStorage storage = FirebaseStorage.getInstance();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareImage = myData.get(position).getImg();
                String shareDescription = "Hey! I just saw a cool posting from Freebay of a %s that I thought you would like!\n";
                share.putExtra(Intent.EXTRA_TEXT, String.format(shareDescription, myData.get(position).getItemName()));
                share.putExtra(Intent.EXTRA_TEXT, shareImage);
                myContext.startActivity(Intent.createChooser(share, "Share using"));
            }
        });
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            DatabaseReference listingRef = FirebaseDatabase.getInstance().getReference().child("Listings").child(myData.get(position).getListingNum());
            DatabaseReference favoriteRef = listingRef.child("favorites").child("isFavorite");
            @Override
            public void onClick(View v) {
                favoriteRef.setValue(true);
            }
        });
        holder.removeFavorite.setOnClickListener(new View.OnClickListener() {
            DatabaseReference listingRef = FirebaseDatabase.getInstance().getReference().child("Listings").child(myData.get(position).getListingNum());
            DatabaseReference favoriteRef = listingRef.child("favorites").child("isFavorite");
            @Override
            public void onClick(View v) {
                favoriteRef.setValue(false);
            }
        });
        holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            DatabaseReference listingRef = FirebaseDatabase.getInstance().getReference().child("Listings").child(myData.get(position).getListingNum());
            DatabaseReference favoriteRef = listingRef.child("favorites").child("isFavorite");
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.addFavorite:
                        favoriteRef.setValue(true);
                        break;
                    case R.id.removeFavorite:
                        favoriteRef.setValue(false);
                        break;
                }
                return false;
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
        Toolbar toolbar;
        ImageButton favorite;
        ImageButton removeFavorite;
        ImageButton share;

        public myViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listingNameCard);
            image = itemView.findViewById(R.id.listingImageCard);
            cardView = itemView.findViewById(R.id.cardview_id);
            toolbar = itemView.findViewById((R.id.buttonsContainer));
            favorite = itemView.findViewById(R.id.favoriteButton);
            removeFavorite = itemView.findViewById(R.id.removeFavoriteButton);
            share = itemView.findViewById(R.id.shareButton);
        }
    }
}
