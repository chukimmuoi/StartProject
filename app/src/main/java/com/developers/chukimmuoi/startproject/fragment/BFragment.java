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
import butterknife.OnClick;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/25/17.
 */

public class BFragment extends BaseFragment {

    private static final String TAG = BFragment.class.getSimpleName();

    public static final int EVENT_B1 = 0x1b;
    public static final int EVENT_B2 = 0x2b;
    public static final int EVENT_B3 = 0x3b;
    public static final int EVENT_B4 = 0x4b;

    public static final String VALUE_TITLE_B = "Title_B";
    public static final String VALUE_MESSAGE_B = "Message_B";

    @BindView(R.id.tv_title_b)
    TextView tvTitleB;
    @BindView(R.id.tv_message_b)
    TextView tvMessageB;
    @BindView(R.id.btn_b)
    Button btnB;

    private String mTitle;
    private String mMessage;

    @Override
    protected void createVariableStart(Bundle bundle) {
        super.createVariableStart(bundle);

        Log.e(TAG, "EVENT_B1 = " + EVENT_B1);
        Log.e(TAG, "EVENT_B2 = " + EVENT_B2);
        Log.e(TAG, "EVENT_B3 = " + EVENT_B3);

        if (bundle != null) {
            mTitle = bundle.getString(VALUE_TITLE_B);
            mMessage = bundle.getString(VALUE_MESSAGE_B);
        }
    }

    @Override
    protected void createVariableNormal() {

    }

    @Override
    protected View setLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    protected void createVariableView(View view, Bundle savedInstanceState) {
        tvTitleB.setText(mTitle);
        tvMessageB.setText(mMessage);
    }

    @OnClick(R.id.btn_b)
    public void onClick() {
        mFragmentListener.onFragmentAction(R.layout.fragment_b, EVENT_B4);
    }
}
