package com.poran.bpl2017live;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivty extends AppCompatActivity {

    private final int SPLASH_TIME=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivity=new Intent(SplashActivty.this,MainActivity.class);
                SplashActivty.this.startActivity(mainActivity);
                SplashActivty.this.finish();
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);

            }
        },SPLASH_TIME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
