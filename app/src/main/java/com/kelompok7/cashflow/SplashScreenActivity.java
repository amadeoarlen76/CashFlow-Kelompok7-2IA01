package com.kelompok7.cashflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread threadTime = new Thread(){
          public void run(){
              try {
                  sleep(2000);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  Intent gotoHome = new Intent(SplashScreenActivity.this, HomeActivity.class);
                  startActivity(gotoHome);
                  finish();
              }
          }
        };
        threadTime.start();
    }
}
