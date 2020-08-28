package com.sbm.nahdapack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private CircleImageView obj_civ_log_img;
    private TextView obj_tv_log_titl;
    Animation animation,animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //region hide toolbar
        getSupportActionBar().hide();
        //endregion

        obj_civ_log_img=(CircleImageView)findViewById(R.id.civ_log_img);
        obj_tv_log_titl=(TextView)findViewById(R.id.tv_log_titl);
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.animator.alpha_disappears);
        animation2=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.trans_slide);

        obj_civ_log_img.startAnimation(animation);
        obj_tv_log_titl.startAnimation(animation2);



    }
}