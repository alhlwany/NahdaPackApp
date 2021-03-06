package com.sbm.nahdapack;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sbm.nahdapack.Class.GnrFunction;
import com.sbm.nahdapack.Class.Gnr_Variable;
import com.sbm.nahdapack.View.SalManMainActivity;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private CircleImageView obj_civ_log_img;
    private TextView obj_tv_log_titl;
    Animation animation, animation2;
    private EditText obj_log_et_user_name, obj_log_et_Password;
    private Button obj_Log_Button, obj_log_lang_Button;
    private ProgressDialog loadingBar;
    GnrFunction gf=new GnrFunction();
    private Spinner obj_spnr_log_type;


    String[] users={"مندوب", "عميل", "مدير", "موظف", "خط الإنتاج"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();

        //region hide toolbar
        getSupportActionBar().hide();
        //endregion
        //region Animation
        obj_civ_log_img=(CircleImageView) findViewById(R.id.civ_log_img);
        obj_tv_log_titl=(TextView) findViewById(R.id.tv_log_titl);
        animation=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.alpha_disappears);
        animation2=AnimationUtils.loadAnimation(getApplicationContext(), R.animator.trans_slide);

        obj_civ_log_img.startAnimation(animation);
        obj_tv_log_titl.startAnimation(animation2);
        //endregion


        obj_Log_Button=(Button) findViewById(R.id.btn_log_login);
        obj_log_lang_Button=(Button) findViewById(R.id.btn_log_lang);
        obj_log_et_Password=(EditText) findViewById(R.id.et_log_pass);
        obj_log_et_user_name=(EditText) findViewById(R.id.et_log_user_name);
        loadingBar=new ProgressDialog(this);
        obj_spnr_log_type=(Spinner) findViewById(R.id.spnr_log_type);

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

        //region spinner
        Spinner spin=(Spinner) findViewById(R.id.spnr_log_type);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        //endregion

        obj_spnr_log_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();
                    gnrVR.setUser(obj_spnr_log_type.getSelectedItem().toString());
                    //Toast.makeText(LoginActivity.this, "" + gnrVR.getUser() + "", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {

                    Toast.makeText(LoginActivity.this, "" + ex.toString() + "", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        obj_Log_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
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

    private void LoginUser() {
        String user=obj_log_et_user_name.getText().toString();
        String password=obj_log_et_Password.getText().toString();

        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "Please write your UserName...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        } else {
            Boolean is_TRUE=gf.GetDataBool("SELECT * FROM dev_users where  user_name='" + user + "'", "Get");
            if (is_TRUE.equals(false)) {
                is_TRUE=gf.GetDataBool("SELECT * FROM dev_users where user_name='" + user + "' and  user_pass='" + password + "'", "Get");
                if (is_TRUE.equals(false)) {
                    loadingBar=new ProgressDialog(LoginActivity.this);
                    loadingBar.setTitle("Login Account");
                    loadingBar.setMessage("Please wait, while we are checking the credentials.");
                    loadingBar.setCanceledOnTouchOutside(true);
                    loadingBar.show();
                    //"مندوب", "عميل", "مدير", "موظف", "خط الإنتاج"
                    Gnr_Variable gnrVR=(Gnr_Variable) getApplicationContext();
                    if (gnrVR.getUser().equals("مندوب")){
                        Intent intent=new Intent(LoginActivity.this, SalManMainActivity.class);
                        startActivity(intent);
                        loadingBar.dismiss();
                    }
                    else if (gnrVR.getUser().equals("عميل")){}
                    else if (gnrVR.getUser().equals("مدير")){}
                    else if (gnrVR.getUser().equals("موظف")){}
                    else if (gnrVR.getUser().equals("خط الإنتاج")){}

                } else {
                    //Toast.makeText(this, "رقم الهاتف غير موجود بقاعده البيانات", Toast.LENGTH_SHORT).show();
                    loadingBar=new ProgressDialog(LoginActivity.this);
                    loadingBar.setTitle("Check");
                    loadingBar.setMessage("كلمة المرور غير صيحيه ...");
                    loadingBar.setCanceledOnTouchOutside(true);
                    loadingBar.show();
                    Runnable progressRunnable=new Runnable() {
                        @Override
                        public void run() {
                            loadingBar.cancel();
                        }
                    };
                    Handler pdCanceller=new Handler();
                    pdCanceller.postDelayed(progressRunnable, 3000);
                }
            } else {
                //Toast.makeText(this, "رقم الهاتف غير موجود بقاعده البيانات", Toast.LENGTH_SHORT).show();
                loadingBar=new ProgressDialog(LoginActivity.this);
                loadingBar.setTitle("Check");
                loadingBar.setMessage("اسم المستخدم غير موجود بقاعده البيانات ...");
                loadingBar.setCanceledOnTouchOutside(true);
                loadingBar.show();
                Runnable progressRunnable=new Runnable() {
                    @Override
                    public void run() {
                        loadingBar.cancel();
                    }
                };

                Handler pdCanceller=new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);
            }
        }
    }
}
