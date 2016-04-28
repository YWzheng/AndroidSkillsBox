package com.ywzheng.androidskillsbox.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.ywzheng.androidskillsbox.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RevealEffectActivity extends AppCompatActivity {

    @InjectView(R.id.circle)
    View mCircle;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_effect);
        ButterKnife.inject(this);
        initToolbar();
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

    private void initToolbar() {

        if (getSupportActionBar() == null) {
            mToolbar.setTitle("");
            mToolbarTitle.setText("RevealEffect");
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
