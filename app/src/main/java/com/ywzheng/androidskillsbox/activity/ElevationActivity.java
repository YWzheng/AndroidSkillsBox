package com.ywzheng.androidskillsbox.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ywzheng.androidskillsbox.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ElevationActivity extends AppCompatActivity {

    @InjectView(R.id.floating_shape)
    View mFloatingShape;
    @InjectView(R.id.floating_shape_2)
    View mFloatingShape2;
    @InjectView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevation);
        ButterKnife.inject(this);
        initToolbar();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.floating_shape, R.id.floating_shape_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floating_shape:
                mFloatingShape.setTranslationZ(120);
                mFloatingShape2.setTranslationZ(12);
                break;
            case R.id.floating_shape_2:
                mFloatingShape.setTranslationZ(12);
                mFloatingShape2.setTranslationZ(120);
                break;
        }
    }

    private void initToolbar() {

        if (getSupportActionBar() == null) {
            mToolbar.setTitle("");
            mToolbarTitle.setText("RefreshLayout");
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
