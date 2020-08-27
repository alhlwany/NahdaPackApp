package com.sbm.nahdapack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView obj_civ_splash_img;
    private TextView obj_tv_splash_title, obj_tv_splash_designby;
    Animation animation, animation2, animation3, animation4, animation_mix;
    private static int OBJ_SPLASH_SCREEN=15000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ///
        obj_civ_splash_img=(ImageView) findViewById(R.id.civ_splash_img);
        obj_tv_splash_title=(TextView) findViewById(R.id.tv_splash_title);
        obj_tv_splash_designby=(TextView) findViewById(R.id.tv_splash_designby);
        ///
        ConstraintLayout constraintLayout = findViewById(R.id.layoutSplash);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        animation_mix=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.zmix_anim);

        animation=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.rotate);
        //animation2=AnimationUtils.loadAnimation(getApplicationContext(),R.animator.rotatex);
        animation2=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.alpha_disappears);
        animation3=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.scale_max_min);
        animation4=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.trans_slide);
        //obj_civ_splash_img.startAnimation(animation);
        obj_civ_splash_img.startAnimation(animation_mix);
        obj_tv_splash_title.startAnimation(animation2);
        //obj_tv_splash_designby.startAnimation(animation3);
        obj_tv_splash_designby.startAnimation(animation4);
    }
}
