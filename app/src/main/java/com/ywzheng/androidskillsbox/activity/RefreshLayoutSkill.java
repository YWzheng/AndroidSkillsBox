package com.ywzheng.androidskillsbox.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ywzheng.androidskillsbox.base.BaseActivity;
import com.ywzheng.androidskillsbox.data.Cheeses;
import com.ywzheng.androidskillsbox.R;

import butterknife.InjectView;

public class RefreshLayoutSkill extends BaseActivity {


    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(android.R.id.list)
    ListView mList;
    private ArrayAdapter mListAdapter;
    private static final int LIST_ITEM_COUNT = 20;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_refresh_layout_skill;
    }

    @Override
    protected String SetToolbarTitle() {
        return "RefreshLayoutSkill";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeRefreshLayout.setColorScheme(
                R.color.swipe_color_1, R.color.swipe_color_2,
                R.color.swipe_color_3, R.color.swipe_color_4);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RefreshLayoutSkill.this, "下拉刷新", Toast.LENGTH_SHORT).show();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                Cheeses.randomList(LIST_ITEM_COUNT));
        mList.setAdapter(mListAdapter);
    }
}
