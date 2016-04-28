package com.ywzheng.androidskillsbox.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

import com.ywzheng.androidskillsbox.R;
import com.ywzheng.androidskillsbox.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class ElevationActivity extends BaseActivity {

    @InjectView(R.id.floating_shape)
    View mFloatingShape;
    @InjectView(R.id.floating_shape_2)
    View mFloatingShape2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_elevation;
    }

    @Override
    protected String SetToolbarTitle() {
        return "ElevationActivity";
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
