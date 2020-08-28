package com.sbm.nahdapack;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;
import com.sbm.nahdapack.Class.GnrFunction;
import com.sbm.nahdapack.Class.Gnr_Variable;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private CircleImageView obj_civ_log_img;
    private TextView obj_tv_log_titl;
    Animation animation,animation2;
    private EditText obj_log_et_user_name, obj_log_et_Password;
    private Button obj_Log_Button, obj_log_lang_Button;
    private ProgressDialog loadingBar;
    GnrFunction gf=new GnrFunction();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();

        //region hide toolbar
        getSupportActionBar().hide();
        //endregion
        //region Animation
        obj_civ_log_img=(CircleImageView)findViewById(R.id.civ_log_img);
        obj_tv_log_titl=(TextView)findViewById(R.id.tv_log_titl);
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.animator.alpha_disappears);
        animation2=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.trans_slide);

        obj_civ_log_img.startAnimation(animation);
        obj_tv_log_titl.startAnimation(animation2);
        //endregion


        obj_Log_Button=(Button) findViewById(R.id.btn_log_login);
        obj_log_lang_Button=(Button) findViewById(R.id.btn_log_lang);
        obj_log_et_Password=(EditText) findViewById(R.id.et_log_pass);
        obj_log_et_user_name=(EditText) findViewById(R.id.et_log_user_name);
        loadingBar=new ProgressDialog(this);

        obj_log_lang_Button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api=Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                String languagename=Locale.getDefault().getDisplayLanguage().toString();
                String country=Locale.getDefault().getCountry();
                if (languagename.equals("English")) {
                    Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();
                    gnrVR.setlang("ar");
                    setLocale("ar");
                    //obj_btn_registr_lang.setText("English");
                } else {
                    Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();
                    gnrVR.setlang("en");
                    setLocale("en");
                    //obj_btn_registr_lang.setText("العربية");
                }

            }
        });
    }

    //region Language
    @RequiresApi(api=Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLocale(String lang) {
        Locale myLocale=new Locale(lang);
        Resources res=getResources();
        DisplayMetrics dm=res.getDisplayMetrics();
        Configuration conf=new Configuration();
        conf.locale=myLocale;
        getApplicationContext().getResources().updateConfiguration(conf, getApplicationContext().getResources().getDisplayMetrics());
        conf.locale=myLocale;
        res.updateConfiguration(conf, getApplicationContext().getResources().getDisplayMetrics());
        Intent refresh=new Intent(this, LoginActivity.class);
        refresh.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(refresh);
        /* Toast.makeText(getApplicationContext(), languagename, Toast.LENGTH_SHORT).show();*/

    }
    //endregion
}