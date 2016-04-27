package com.ywzheng.androidskillsbox.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.ywzheng.androidskillsbox.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RevealEffectActivity extends AppCompatActivity {

    @InjectView(R.id.circle)
    View mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_effect);
        ButterKnife.inject(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.button)
    public void onClick() {


        // Create a reveal {@link Animator} that starts clipping the view from
        // the top left corner until the whole view is covered.
        Animator animator = ViewAnimationUtils.createCircularReveal(
                mCircle,
                0,
                0,
                0,
                (float) Math.hypot(mCircle.getWidth(), mCircle.getHeight()));

        // Set a natural ease-in/ease-out interpolator.
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        // Finally start the animation
        animator.start();
    }
}
