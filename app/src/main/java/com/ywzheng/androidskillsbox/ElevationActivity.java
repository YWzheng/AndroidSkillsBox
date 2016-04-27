package com.ywzheng.androidskillsbox;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ElevationActivity extends AppCompatActivity {

    @InjectView(R.id.floating_shape)
    View mFloatingShape;
    @InjectView(R.id.floating_shape_2)
    View mFloatingShape2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevation);
        ButterKnife.inject(this);
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
}
