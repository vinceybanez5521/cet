package com.bit.cet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim, leftAnim, rightAnim;
    private ImageView iv_logo;
    private TextView tv_app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.to_top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.to_left_anim);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.to_right_anim);

        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        tv_app_name = (TextView) findViewById(R.id.tv_app_name);

        iv_logo.setAnimation(bottomAnim);
        tv_app_name.setAnimation(topAnim);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 5000);
    }
}