package com.example.test;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter myAdapter;
    private Toolbar toolbar;
    private SearchView searchView;
    private ImageButton sort;
    private BottomNavigationView bottomNavView;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef = storage.getReferenceFromUrl("gs://freebay-cbb54.appspot.com");
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference().child("Listings");

    private List<listingObjects> listings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.topBar);
        searchView = findViewById(R.id.search);
        sort = findViewById(R.id.sort);
        bottomNavView = findViewById(R.id.bottomBar);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.accountSettings:
                        Intent intent = new Intent(MainActivity.this,AccountSettingsActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        searchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.sort:
                        sortDialog();
                        break;
                }
            }
        });

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.myListings:
                        Intent myListingIntent = new Intent(MainActivity.this,MyListingsActivity.class);
                        startActivity(myListingIntent);
                        break;
                    case R.id.addListing:
                        Intent addListingIntent = new Intent(MainActivity.this,AddListingActivity.class);
                        startActivity(addListingIntent);
                        break;
                    case R.id.favorite:
                        Intent favoriteIntent = new Intent(MainActivity.this,FavoritesActivity.class);
                        startActivity(favoriteIntent);
                        break;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listings = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listings.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    listingObjects listing = postSnapshot.getValue(listingObjects.class);
                    listings.add(listing);
                }

                myAdapter = new RecyclerViewAdapter(MainActivity.this, listings);

                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void sortDialog() {
        String[] sortByList = getResources().getStringArray(R.array.sortByArray);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Sort by");
        builder.setSingleChoiceItems(sortByList, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
