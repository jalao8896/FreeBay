package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ad_Activity extends AppCompatActivity {

    private TextView title_tv, description_tv, category_tv;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_);

        title_tv = (TextView) findViewById(R.id.adTitle);
        description_tv = (TextView) findViewById(R.id.adDescription);
        category_tv = (TextView) findViewById(R.id.adCategory);
        img = (ImageView) findViewById(R.id.adThumbnail);


        //Receive data from Main_Activity

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Ad Title");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Ad Body");
        int image = intent.getExtras().getInt("Thumbnail");

        //Setting the values
        title_tv.setText(Title);
        description_tv.setText(Description);
        category_tv.setText(Category);
        img.setImageResource(image);

    }
}
