package com.deneme.at.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Asus on 31.8.2016.
 */
public class nasil extends Activity {

   ImageView resim;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nasil);

        resim=(ImageView)findViewById(R.id.imageView3);
        resim.setBackgroundResource(R.drawable.resim);
        AnimationDrawable animation =(AnimationDrawable) resim.getBackground();
        animation.start();

    }

}
