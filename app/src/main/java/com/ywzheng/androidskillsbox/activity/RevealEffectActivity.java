package com.ywzheng.androidskillsbox.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.ywzheng.androidskillsbox.base.BaseActivity;
import com.ywzheng.androidskillsbox.R;

import butterknife.InjectView;
import butterknife.OnClick;

public class RevealEffectActivity extends BaseActivity {

    @InjectView(R.id.circle)
    View mCircle;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_reveal_effect;
    }

    @Override
    protected String SetToolbarTitle() {
        return "RevealEffectActivity";
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.button)
    public void onClick() {
        // Create a reveal {@link Animator} that starts clipping the view from
        // the top left corner until the whole view is covered.
        Animator animator = ViewAnimationUtils.createCircularReveal(
                mCircle, 0, 0, 0,
                (float) Math.hypot(mCircle.getWidth(), mCircle.getHeight()));
        // Set a natural ease-in/ease-out interpolator.
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        // Finally start the animation
        animator.start();
    }
}
