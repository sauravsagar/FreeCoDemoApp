package com.saurav.freecodemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 videosViewPager = findViewById(R.id.videosviewPager);


        List<VideoItemBin> videoItemBins = new ArrayList<>();

        VideoItemBin videoItem1 = new VideoItemBin();
        videoItem1.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        videoItem1.videoTitle = "PinkSky";
        videoItem1.videoDescription = "Mountains with snow below a pink sky";
        videoItemBins.add(videoItem1);

        VideoItemBin videoItem2 = new VideoItemBin();
        videoItem2.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
        videoItem2.videoTitle = "Elephant";
        videoItem2.videoDescription = "Elephants dream animation";
        videoItemBins.add(videoItem2);

        VideoItemBin videoItem3 = new VideoItemBin();
        videoItem3.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4";
        videoItem3.videoTitle = "Car";
        videoItem3.videoDescription = "Car racing is a passion";
        videoItemBins.add(videoItem3);

        VideoItemBin videoItem4 = new VideoItemBin();
        videoItem4.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4";
        videoItem4.videoTitle = "GOT";
        videoItem4.videoDescription = "Game of Thrones Animation";
        videoItemBins.add(videoItem4);

        videosViewPager.setAdapter(new VideoAdapterClass(videoItemBins));

        //Nav Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_search:
                        Intent intent = new Intent(MainActivity.this, AutoCompleteSearchActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_chat:
                        Toast.makeText(MainActivity.this, "Chat", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
}
