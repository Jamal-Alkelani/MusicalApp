package com.sbda.gamal.musicalapp;

import android.content.Intent;
import android.database.DataSetObserver;
import android.media.Image;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ArrayList<Song> songs;
    private ImageView play;
    private boolean isPlaying=true;
    private int minitues=0;
    private int secconds=0;
    private ProgressBar progressBar;
    private char characters[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private ImageView footerIcon;
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomBarWithNavigationBarAndToolBar();
        initializeSongs();
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        SongsAdapter songsAdapter=new SongsAdapter(this,0,songs);
        songsAdapter.setProgressBar(progressBar);
        songsAdapter.setActivity(this);
        ListView listView=(ListView) findViewById(R.id.songsList);
        listView.setAdapter(songsAdapter);
        registerControls();
        footerIcon=(ImageView) findViewById(R.id.footerIcon);
        footerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SongPlaying.class));
            }
        });

        final LottieAnimationView anim=(LottieAnimationView) findViewById(R.id.play_pause_animation_main);
        PlayAnimation playAnimation=new PlayAnimation(anim);
        playAnimation.intializeAnimation();
    }

    private void setCustomBarWithNavigationBarAndToolBar() {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Music");
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        songs=new ArrayList<Song>();
    }

    private void registerControls() {




    }

    private void initializeSongs() {
        songs.add(new Song("SoundWave","Spinnin Records","3:22",-1));
        songs.add(new Song("Minion Banana song","Scroopy Art Z","2:42",-1));
        songs.add(new Song("Young Thug","Camila Cabello","3:38",-1));
        songs.add(new Song("Imagine Dragons - Believer","Trap Nation","3:19",-1));
        songs.add(new Song("Hold On & Believe","Martin Garrix","3:54",-1));
        songs.add(new Song("SoundWave","Spinnin Records","3:22",-1));
        songs.add(new Song("Minion Banana song","Scroopy Art Z","2:42",-1));
        songs.add(new Song("Young Thug","Camila Cabello","3:38",-1));
        songs.add(new Song("Imagine Dragons - Believer","Trap Nation","3:19",-1));
        songs.add(new Song("Hold On & Believe","Martin Garrix","3:54",-1));
        songs.add(new Song("SoundWave","Spinnin Records","3:22",-1));
        songs.add(new Song("Minion Banana song","Scroopy Art Z","2:42",-1));
        songs.add(new Song("Young Thug","Camila Cabello","3:38",-1));
        songs.add(new Song("Imagine Dragons - Believer","Trap Nation","3:19",-1));
        songs.add(new Song("Hold On & Believe","Martin Garrix","3:54",-1));
        songs.add(new Song("SoundWave","Spinnin Records","3:22",-1));
        songs.add(new Song("Minion Banana song","Scroopy Art Z","2:42",-1));
        songs.add(new Song("Young Thug","Camila Cabello","3:38",-1));
        songs.add(new Song("Imagine Dragons - Believer","Trap Nation","3:19",-1));
        songs.add(new Song("Hold On & Believe","Martin Garrix","3:54",-1));
        songs.add(new Song("SoundWave","Spinnin Records","3:22",-1));
        songs.add(new Song("Minion Banana song","Scroopy Art Z","2:42",-1));
        songs.add(new Song("Young Thug","Camila Cabello","3:38",-1));
        songs.add(new Song("Imagine Dragons - Believer","Trap Nation","3:19",-1));
        songs.add(new Song("Hold On & Believe","Martin Garrix","3:54",-1));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
