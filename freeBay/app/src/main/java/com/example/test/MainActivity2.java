package com.example.test;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView myrv;
    private RecyclerViewAdapter myAdapter;

    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef = storage.getReferenceFromUrl("gs://freebay-cbb54.appspot.com");
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference().child("Listings");

    private List<listingObjects> adListings;

    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pb = (ProgressBar) findViewById(R.id.progressBarNews);


        // This stuff is just to test functionality.
        // Real data will need to be extracted from Firebase once finished.


        myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        myrv.setHasFixedSize(true);

        myrv.setLayoutManager(new LinearLayoutManager(this));

        adListings = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    listingObjects listing = postSnapshot.getValue(listingObjects.class);
                    adListings.add(listing);
                }

                myAdapter = new RecyclerViewAdapter(MainActivity2.this, adListings);

                myrv.setAdapter(myAdapter);
                pb.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity2.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                pb.setVisibility(View.INVISIBLE);
            }
        });
    }
}
