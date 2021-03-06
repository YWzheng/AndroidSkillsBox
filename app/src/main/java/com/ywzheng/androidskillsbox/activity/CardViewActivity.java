package com.ywzheng.androidskillsbox.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

import com.ywzheng.androidskillsbox.base.BaseActivity;
import com.ywzheng.androidskillsbox.R;

import butterknife.InjectView;

public class CardViewActivity extends BaseActivity {

    @InjectView(R.id.cardview)
    CardView mCardview;
    @InjectView(R.id.cardview_radius_seekbar)
    SeekBar mCardviewRadiusSeekbar;
    @InjectView(R.id.cardview_elevation_seekbar)
    SeekBar mCardviewElevationSeekbar;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_card_view;
    }

    @Override
    protected String SetToolbarTitle() {
        return "CardViewActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCardviewRadiusSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardview.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mCardviewElevationSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCardview.setElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
