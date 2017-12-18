package com.hlq.animalsafari;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View mFirstView, mSecondView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstView = findViewById(R.id.ll_first);
        mSecondView = findViewById(R.id.iv_second);

    }

    public void getStartFirstAnimation(View view) {
        // 翻转
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(mFirstView, "rotationX", 0f, 25f);
        rotationX.setDuration(300);
        // 透明
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mFirstView, "alpha", 1f, 0.5f);
        alpha.setDuration(200);
        // 缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mFirstView, "scaleX", 1f, 0.8f);
        scaleX.setDuration(300);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mFirstView, "scaleY", 1f, 0.8f);
        scaleY.setDuration(300);

//        rotationX.addUpdateListener();
        ObjectAnimator resumeRotationX = ObjectAnimator.ofFloat(mFirstView, "rotationX", 25f, 0f);
        resumeRotationX.setDuration(200);
        // 延迟执行
        resumeRotationX.setStartDelay(200);

        // 由于缩放造成 离顶部有一段距离 需要平移上去
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mFirstView, "translationY", 0f, -0.1f * mFirstView.getHeight());
        translationY.setDuration(200);

        // 第二个view执行平移动画 往上
        ObjectAnimator secondTranslationY = ObjectAnimator.ofFloat(mSecondView, "translationY", mSecondView.getHeight(), 0f);
        secondTranslationY.setDuration(200);
        secondTranslationY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mSecondView.setVisibility(View.VISIBLE);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotationX, alpha, scaleX, scaleY, resumeRotationX, translationY, secondTranslationY);
        set.start();

    }

    public void getStartSecondAnimation(View view) {
        getAnimationStart();
    }

    private void getAnimationStart() {
        // 翻转
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(mFirstView, "rotationX", 0f, 25f);
        rotationX.setDuration(300);
        // 透明
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mFirstView, "alpha", 0.5f, 1f);
        alpha.setDuration(200);
        // 缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mFirstView, "scaleX", 0.8f, 1f);
        scaleX.setDuration(300);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mFirstView, "scaleY", 0.8f, 1f);
        scaleY.setDuration(300);

//        rotationX.addUpdateListener();
        ObjectAnimator resumeRotationX = ObjectAnimator.ofFloat(mFirstView, "rotationX", 25f, 0f);
        resumeRotationX.setDuration(200);
        // 延迟执行
        resumeRotationX.setStartDelay(200);

        // 由于缩放造成 离顶部有一段距离 需要平移上去
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mFirstView, "translationY", -0.1f * mSecondView.getHeight(), 0f);
        translationY.setDuration(200);

        // 第二个view执行平移动画 往上
        ObjectAnimator secondTranslationY = ObjectAnimator.ofFloat(mSecondView, "translationY", mSecondView.getHeight(), 0f);
        secondTranslationY.setDuration(200);
        secondTranslationY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mSecondView.setVisibility(View.GONE);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotationX, alpha, scaleX, scaleY, resumeRotationX, translationY, secondTranslationY);
        set.start();
    }

    public void getOut(View view) {
        startActivity(new Intent(this, MDAnimationActivity.class));
    }

}
