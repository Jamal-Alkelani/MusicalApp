package com.sbda.gamal.musicalapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;


public class SongPlaying extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);
        back=(ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final LottieAnimationView anim=(LottieAnimationView) findViewById(R.id.play_pause_animation);
        PlayAnimation playAnimation=new PlayAnimation(anim);
        playAnimation.intializeAnimation();

    }
}
