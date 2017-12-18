package com.hlq.animalsafari;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;

public class MDAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdanmaiton);
    }

    public void getSelectable(View view) {
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(view,
                view.getWidth() / 2, view.getHeight() / 2,
                0, view.getWidth());
        circularReveal.setDuration(1500);
        circularReveal.setInterpolator(new AccelerateInterpolator());
        circularReveal.start();
    }

    public void getSelectable1(View view) {
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(view,
                0, 0,
                0, (float) Math.hypot(view.getWidth(), view.getHeight()));
        circularReveal.setDuration(1500);
        circularReveal.setInterpolator(new AccelerateInterpolator());
        circularReveal.start();
    }

}
