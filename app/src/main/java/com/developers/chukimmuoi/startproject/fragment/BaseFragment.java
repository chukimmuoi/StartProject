package com.developers.chukimmuoi.startproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.chukimmuoi.startproject.BaseActivity;

import butterknife.ButterKnife;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/19/17.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();

    protected BaseActivity mContext;

    protected OnFragmentListener mFragmentListener;

    /**
     * 1. Call when Fragment connect Activity.
     * {@link #onDetach()}
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = (BaseActivity) getActivity();

        if(mContext instanceof OnFragmentListener) {
            mFragmentListener = (OnFragmentListener) mContext;
        }
    }

    /**
     * 2. Use onCreate variable not UI.
     * eg: context, adapter, arrayList
     * {@link #onDestroy()}
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            createVariableStart(bundle);
        }

        createVariableNormal();
    }

    /**
     * 3. Set layout XML.
     * {@link #onDestroyView()}
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = setLayout(inflater, container, savedInstanceState);

        ButterKnife.bind(this, view);

        return view;
    }

    /**
     * 4. Set variable UI.
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createVariableView(view, savedInstanceState);
    }

    /**
     * 5. Call when Activity complete method onCreate().
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 5. Call when fragment ready show on screen.
     * {@link #onStop()}
     */
    @Override
    public void onStart() {
        super.onStart();
    }

    /**
     * 6. Handle resources. Multi screen.
     * {@link #onPause()}
     */
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        mContext = null;

        mFragmentListener = null;

        super.onDetach();
    }

    /**
     * Bundle bundle = getArguments()
     */
    protected void createVariableStart(Bundle bundle) {

    }

    protected abstract void createVariableNormal();

    protected abstract View setLayout(LayoutInflater inflater, ViewGroup container,
                                      Bundle savedInstanceState);

    protected abstract void createVariableView(View view, Bundle savedInstanceState);

    public interface OnFragmentListener {
        void onFragmentAction(int layoutId, @Nullable int event);
    }
}
