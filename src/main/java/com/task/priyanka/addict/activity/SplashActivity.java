package com.task.priyanka.addict.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.task.priyanka.addict.R;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifDrawable;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 4000;
    private ImageView iv_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashHandler();
        initUi();
    }

    private void initUi() {
        iv_splash = findViewById(R.id.iv_splash);
        try {
            GifDrawable gifFromResource = new GifDrawable( getResources(), R.drawable.ic_addict);
            iv_splash.setImageDrawable(gifFromResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void splashHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, TrackerActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}
