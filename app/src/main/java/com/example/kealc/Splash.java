package com.example.kealc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Splash extends AppCompatActivity {

    TextView appname;

    Animation apptitlefade;
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appname = (TextView)findViewById(R.id.name);
        apptitlefade = AnimationUtils.loadAnimation(this, R.anim.textview);

        appname.setAnimation(apptitlefade);

        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(6000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}