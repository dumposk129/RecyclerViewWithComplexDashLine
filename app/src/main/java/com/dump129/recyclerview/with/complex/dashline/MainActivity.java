package com.dump129.recyclerview.with.complex.dashline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvContent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SomethingAdapter(createSomething()));
    }

    private List<SomethingData> createSomething() {
        return Arrays.asList(
                new SomethingData("Android 4.4 KitKat", "Android KitkKat helped you get things done with just the sound of your " +
                        "voice - just say \"OK Google\" to launch voice search, send a text, get directions, or even play a song. and when you are hands on with your device, a new immersive design brings your content to center stage.", "October 31, 2013"),
                new SomethingData("Android 5.0 Lollipop", "Android arrives on screens big ad small - from phones and tablets to watches, TVs and cars. Lollipop has a bold visual style and the fluid tactile response of Material Design.", "November 12, 2014"),
                new SomethingData("Android 6.0  Marshmallow", "Now there's s'more to love about your mobile device: easy shortcut to smart answers with Now on Tap, battery life that can last longer and new app permissions that give you more control.", "October, 5, 2015"),
        new SomethingData("Android 7.0 Nougat", "This is a current version of Android, it's improve performance and add features for example change font size and display size, split-screen, bundled and reply notifications, quicker settings and app shortcuts", "August 22, 2016")
        );
    }
}
