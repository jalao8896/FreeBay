package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class listings extends AppCompatActivity {

    private TextView name, condition, description, contactInfo;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listings);

        name = findViewById(R.id.listingName);
        condition = findViewById(R.id.listingCondition);
        description = findViewById(R.id.listingDescription);
        contactInfo = findViewById(R.id.listingContactInformation);
        img = findViewById(R.id.listingImage);


        //Receive data from Main_Activity

        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Listing Name");
        String Condition = intent.getExtras().getString("Listing Condition");
        String Description = intent.getExtras().getString("Listing Description");
        String Contact = intent.getExtras().getString("Listing Contact Information");
        String imageURL = intent.getExtras().getString("Listing Image");

        //Setting the values
        name.setText(Name);
        condition.setText(Condition);
        description.setText(Description);
        contactInfo.setText(Contact);
        Glide.with(this).load(imageURL).into(img);
    }
}
