package com.example.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Advertisement;
import com.example.test.R;
import com.example.test.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    List<Advertisement> lstAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // This stuff is just to test functionality.
        // Real data will need to be extracted from Firebase once finished.
        lstAd = new ArrayList<>();
        lstAd.add(new Advertisement("Gamer Girl Garbage", "Other", "Trash produced by ur favorite gamer grl", R.drawable.trash));
        lstAd.add(new Advertisement("Bicycle", "Cars+Bikes", "0-60 depending on incline", R.drawable.bike));
        lstAd.add(new Advertisement("Widowmaker Statue", "General", "Widowmaker statue, only used once for reasons", R.drawable.fapstatue));
        lstAd.add(new Advertisement("Gameboy Color", "Technology", "Green gameboy, comes with red version", R.drawable.gameboy));
        lstAd.add(new Advertisement("Old ass book", "Antiques", "Found this super old book in a sarcophagus.", R.drawable.lostbook));
        lstAd.add(new Advertisement("Gamer Girl Garbage", "Other", "Trash produced by ur favorite gamer grl", R.drawable.trash));
        lstAd.add(new Advertisement("Bicycle", "Cars+Bikes", "I like to ride my bicycle", R.drawable.bike));
        lstAd.add(new Advertisement("Widowmaker Statue", "General", "Widowmaker statue, only used once for reasons", R.drawable.fapstatue));
        lstAd.add(new Advertisement("Gameboy Color", "Technology", "Green gameboy, comes with red version", R.drawable.gameboy));
        lstAd.add(new Advertisement("Old ass book", "Antiques", "Found this super old book in a sarcophagus.", R.drawable.lostbook));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstAd);
        myrv.setLayoutManager(new GridLayoutManager(this, 1));
        myrv.setAdapter(myAdapter);
    }
}