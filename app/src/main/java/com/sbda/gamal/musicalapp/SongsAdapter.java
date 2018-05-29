package com.sbda.gamal.musicalapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.List;

public class SongsAdapter extends ArrayAdapter<Song> {
    private Context context;
    private ProgressBar progressBar;
    private Activity activity;
    public SongsAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, 0, objects);
        this.context=context;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View listView=convertView;
        if(listView==null){
            listView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        final TextView name=(TextView) listView.findViewById(R.id.name);
        final TextView artist=(TextView) listView.findViewById(R.id.artist);
        final TextView duration=(TextView) listView.findViewById(R.id.duration);
        ImageView imageView=(ImageView) listView.findViewById(R.id.image);
        final LottieAnimationView playAnimatopn=(LottieAnimationView) listView.findViewById(R.id.animation_view);

        Song song=getItem(position);
        if (song.getName().length()>20){
            name.setText(song.getName().substring(0,16)+"...");
        }else{
            name.setText(song.getName());
        }

        if (song.getArtist().length()>25){
            artist.setText(song.getArtist().substring(0,12)+"...");
        }else{
            artist.setText(song.getArtist());
        }

        duration.setText(song.getDuration());
        if(song.getImage()==-1){
            imageView.setImageResource(R.drawable.ic_library_music_black_48dp);
        }else{
            imageView.setImageResource(song.getImage());
        }

        listView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                playAnimatopn.setVisibility(View.VISIBLE);
                name.setTextColor(Color.parseColor("#F50057"));
                artist.setTextColor(Color.parseColor("#F50057"));
                duration.setTextColor(Color.parseColor("#F50057"));
                Song song=getItem(position);
                v.findViewById(R.id.name);
                String name;
                if (song.getName().length()>15){
                    name=song.getName().substring(0,12)+"...";
                }else{
                    name=song.getName();
                }
                setFooter(song.getImage(),name);
                itemPlayed(song);
            }
        });
        
        return listView;

    }

    private void setFooter(int image,String name){

        TextView textView=(TextView) activity.findViewById(R.id.footerSongName);
        textView.setText(name);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void itemPlayed( Song song){
        String duration=song.getDuration();
        String temp[]=duration.split(":");
        int min=Integer.parseInt(temp[0]);
        int sec=Integer.parseInt(temp[1]);
        int durationInSeconds=min*60+sec;
        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 1, 100);
        anim.setDuration(durationInSeconds*500);
        progressBar.startAnimation(anim);

    }
}
