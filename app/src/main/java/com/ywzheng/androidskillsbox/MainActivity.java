package com.ywzheng.androidskillsbox;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ywzheng.androidskillsbox.activity.ElevationActivity;
import com.ywzheng.androidskillsbox.activity.RefreshLayoutSkill;
import com.ywzheng.androidskillsbox.activity.RevealEffectActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mToolbar.setTitle("");
        mToolbarTitle.setText(R.string.app_name);
        setSupportActionBar(mToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch (item.getItemId()) {
            case R.id.action_github:
                intent.setData(Uri.parse("https://github.com/ywzheng"));
                startActivity(intent);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.button, R.id.button1,R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this, RefreshLayoutSkill.class));
                break;
            case R.id.button1:
                startActivity(new Intent(this, RevealEffectActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, ElevationActivity.class));
                break;
            default:
                break;
        }
    }
}
