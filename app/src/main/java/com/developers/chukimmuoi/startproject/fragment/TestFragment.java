package com.developers.chukimmuoi.startproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.developers.chukimmuoi.startproject.R;

import butterknife.BindView;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/19/17.
 */

public class TestFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = TestFragment.class.getSimpleName();

    @BindView(R.id.tv_test)
    public TextView mTvTest;

    @BindView(R.id.btn_test)
    public Button mBtnTest;


    @Override
    public View setLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void createView(View view, Bundle savedInstanceState) {
        mTvTest.setTypeface(mContext.typefaceRegular);

        mBtnTest.setTypeface(mContext.typefaceRegular);
        mBtnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Log.e(TAG, "Button Test 1");
                break;
        }
    }
}
