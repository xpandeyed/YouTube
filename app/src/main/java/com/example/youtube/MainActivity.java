package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        RecyclerView rvVideos = findViewById(R.id.rv_videos);
        rvVideos.setLayoutManager(linearLayoutManager);
        rvVideos.setItemAnimator(new DefaultItemAnimator());
        VideoRvAdapter adapter = new VideoRvAdapter(this);
        rvVideos.setAdapter(adapter);


    }
}