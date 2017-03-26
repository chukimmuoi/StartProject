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

public class AFragment extends BaseFragment {

    private static final String TAG = AFragment.class.getSimpleName();

    public static final int EVENT_A1 = 0x1a;
    public static final int EVENT_A2 = 0x2a;
    public static final int EVENT_A3 = 0x3a;
    public static final int EVENT_A4 = 0x4a;

    public static final String VALUE_TITLE_A = "Title_A";
    public static final String VALUE_MESSAGE_A = "Message_A";

    @BindView(R.id.tv_title_a)
    TextView tvTitleA;
    @BindView(R.id.tv_message_a)
    TextView tvMessageA;
    @BindView(R.id.btn_a)
    Button btnA;

    private String mTitle;
    private String mMessage;



    @Override
    protected void createVariableStart(Bundle bundle) {
        super.createVariableStart(bundle);

        Log.e(TAG, "EVENT_A1 = " + EVENT_A1);
        Log.e(TAG, "EVENT_A2 = " + EVENT_A2);
        Log.e(TAG, "EVENT_A3 = " + EVENT_A3);

        if (bundle != null) {
            mTitle = bundle.getString(VALUE_TITLE_A);
            mMessage = bundle.getString(VALUE_MESSAGE_A);
        }
    }

    @Override
    protected void createVariableNormal() {

    }

    @Override
    protected View setLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    protected void createVariableView(View view, Bundle savedInstanceState) {
        tvTitleA.setText(mTitle);
        tvMessageA.setText(mMessage);
    }

    @OnClick(R.id.btn_a)
    public void onClick() {
        mFragmentListener.onFragmentAction(R.layout.fragment_a, EVENT_A4);
    }
}
