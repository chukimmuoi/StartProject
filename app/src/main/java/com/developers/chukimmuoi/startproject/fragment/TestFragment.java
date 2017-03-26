package com.developers.chukimmuoi.startproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
 * Created by chukimmuoi on 3/19/17.
 */

public class TestFragment extends BaseFragment {

    private static final String TAG = TestFragment.class.getSimpleName();

    @BindView(R.id.btn_frm_a1)
    Button btnFrmA1;
    @BindView(R.id.btn_frm_a2)
    Button btnFrmA2;
    @BindView(R.id.btn_frm_a3)
    Button btnFrmA3;
    @BindView(R.id.btn_frm_b1)
    Button btnFrmB1;
    @BindView(R.id.btn_frm_b2)
    Button btnFrmB2;
    @BindView(R.id.btn_frm_b3)
    Button btnFrmB3;
    @BindView(R.id.btn_frm_c1)
    Button btnFrmC1;
    @BindView(R.id.btn_frm_c2)
    Button btnFrmC2;
    @BindView(R.id.btn_frm_c3)
    Button btnFrmC3;

    @Override
    protected void createVariableNormal() {

    }

    @Override
    public View setLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    protected void createVariableView(View view, Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_frm_a1, R.id.btn_frm_a2, R.id.btn_frm_a3,
            R.id.btn_frm_b1, R.id.btn_frm_b2, R.id.btn_frm_b3,
            R.id.btn_frm_c1, R.id.btn_frm_c2, R.id.btn_frm_c3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_frm_a1:
                mFragmentListener.onFragmentAction(R.layout.fragment_a, AFragment.EVENT_A1);
                break;
            case R.id.btn_frm_a2:
                mFragmentListener.onFragmentAction(R.layout.fragment_a, AFragment.EVENT_A2);
                break;
            case R.id.btn_frm_a3:
                mFragmentListener.onFragmentAction(R.layout.fragment_a, AFragment.EVENT_A3);
                break;
            case R.id.btn_frm_b1:
                mFragmentListener.onFragmentAction(R.layout.fragment_b, BFragment.EVENT_B1);
                break;
            case R.id.btn_frm_b2:
                mFragmentListener.onFragmentAction(R.layout.fragment_b, BFragment.EVENT_B2);
                break;
            case R.id.btn_frm_b3:
                mFragmentListener.onFragmentAction(R.layout.fragment_b, BFragment.EVENT_B3);
                break;
            case R.id.btn_frm_c1:
                mFragmentListener.onFragmentAction(R.layout.fragment_c, CFragment.EVENT_C1);
                break;
            case R.id.btn_frm_c2:
                mFragmentListener.onFragmentAction(R.layout.fragment_c, CFragment.EVENT_C2);
                break;
            case R.id.btn_frm_c3:
                mFragmentListener.onFragmentAction(R.layout.fragment_c, CFragment.EVENT_C3);
                break;
        }
    }
}
