package com.ywzheng.androidskillsbox.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.ywzheng.androidskillsbox.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yongwei on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    protected abstract int getContentViewId();
    protected abstract String SetToolbarTitle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.inject(this);
        initToolbar();
    }
    private void initToolbar() {

        if (getSupportActionBar() == null) {
            mToolbar.setTitle("");
            mToolbarTitle.setText(SetToolbarTitle());
            setSupportActionBar(mToolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



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
