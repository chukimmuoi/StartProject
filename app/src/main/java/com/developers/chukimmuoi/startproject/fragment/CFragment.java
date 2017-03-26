package com.developers.chukimmuoi.startproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by chukimmuoi on 3/25/17.
 */

public class CFragment extends BaseFragment {

    private static final String TAG = CFragment.class.getSimpleName();

    public static final int EVENT_C1 = 0x1C;
    public static final int EVENT_C2 = 0x2C;
    public static final int EVENT_C3 = 0x3C;

    public static final String VALUE_TITLE_C = "Title_C";
    public static final String VALUE_MESSAGE_C = "Message_C";

    @BindView(R.id.tv_title_c)
    TextView tvTitleC;
    @BindView(R.id.tv_message_c)
    TextView tvMessageC;

    private String mTitle;
    private String mMessage;

    @Override
    protected void createVariableStart(Bundle bundle) {
        super.createVariableStart(bundle);

        Log.e(TAG, "EVENT_C1 = " + EVENT_C1);
        Log.e(TAG, "EVENT_C2 = " + EVENT_C2);
        Log.e(TAG, "EVENT_C3 = " + EVENT_C3);

        if (bundle != null) {
            mTitle = bundle.getString(VALUE_TITLE_C);
            mMessage = bundle.getString(VALUE_MESSAGE_C);
        }
    }

    @Override
    protected void createVariableNormal() {

    }

    @Override
    protected View setLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    protected void createVariableView(View view, Bundle savedInstanceState) {
        tvTitleC.setText(mTitle);
        tvMessageC.setText(mMessage);
    }
}
