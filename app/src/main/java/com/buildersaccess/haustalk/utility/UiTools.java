package com.buildersaccess.haustalk.utility;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.buildersaccess.haustalk.R;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public class UiTools {

    public static void setActionBarLayout(AppCompatActivity activity,String title ) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            View mCustomView = activity.getLayoutInflater().inflate(R.layout.actionbar, null);
            TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.action_bar_title);
            mTitleTextView.setText(title);
            actionBar.setCustomView(mCustomView, new
                    ActionBar.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT,
                    GridLayout.LayoutParams.WRAP_CONTENT));
            ActionBar.LayoutParams mP = (ActionBar.LayoutParams) mCustomView.getLayoutParams();
            mP.gravity = mP.gravity & Gravity.CENTER;
            actionBar.setCustomView(mCustomView, mP);
        }
    }
    public static  void setBackActionBarLayout(final AppCompatActivity activity,String title ) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            View mCustomView = activity.getLayoutInflater().inflate(R.layout.actionbar_back, null);
            TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.action_bar_title);
            mTitleTextView.setText(title);
            actionBar.setCustomView(mCustomView, new
                    ActionBar.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT,
                    GridLayout.LayoutParams.WRAP_CONTENT));
            ActionBar.LayoutParams mP = (ActionBar.LayoutParams) mCustomView.getLayoutParams();
            mP.gravity = mP.gravity & Gravity.CENTER_VERTICAL;

            ImageButton imageButton = (ImageButton) mCustomView.findViewById(R.id.ibtn_goback);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.finish();
                    activity.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                }
            });
            actionBar.setCustomView(mCustomView, mP);
        }
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
