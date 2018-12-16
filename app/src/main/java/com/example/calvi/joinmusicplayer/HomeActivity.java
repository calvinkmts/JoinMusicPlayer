package com.example.calvi.joinmusicplayer;

import android.database.sqlite.SQLiteDatabase;
import android.media.MediaMetadataRetriever;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "MusicListActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        DatabaseHelper songs = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = songs.getReadableDatabase();

        ArrayList<DataModel> songList = (ArrayList) songs.getData();

        for (int i=0 ;i<songList.size(); i++) {
            Log.i("COBA 1", songList.get(i).getTitle());
            mNames.add(songList.get(i).getTitle());
            mImageUrls.add(songList.get(i).getImage());
        }

        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, songList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}