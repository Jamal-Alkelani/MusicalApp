package com.sbda.gamal.musicalapp;

import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class PlayAnimation {
    LottieAnimationView anim;
    boolean isPlaying =false;

    public PlayAnimation(LottieAnimationView anim){
        this.anim=anim;
    }
    public void intializeAnimation(){
        anim.setSpeed(3f);
        anim.pauseAnimation();
        anim.addAnimatorUpdateListener((animation) -> {
            if(animation.getAnimatedFraction()>0.5f && isPlaying)
            {
                anim.setMinAndMaxFrame(100,150);
                anim.setSpeed(1f);

            }
            if(!isPlaying){
                anim.setMinAndMaxFrame(160,500);
                anim.setSpeed(3f);
            }
            if(animation.getAnimatedFraction()>0.99f && !isPlaying){
                anim.pauseAnimation();
                anim.setMinFrame(20);
            }



        });

        anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                anim.playAnimation();
                isPlaying =!isPlaying;

            }
        });
    }
}
