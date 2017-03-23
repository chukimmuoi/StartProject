package com.developers.chukimmuoi.startproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.developers.chukimmuoi.shared.utils.TypefaceUtil;
import com.developers.chukimmuoi.startproject.fragment.BaseFragment;
import com.developers.chukimmuoi.startproject.listener.callback.ICallback;
import com.developers.chukimmuoi.startproject.view.IBaseActivityView;
import com.developers.chukimmuoi.startproject.view.IBaseFragmentView;

import butterknife.ButterKnife;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/11/17.
 */

public class BaseActivity extends FragmentActivity implements IBaseActivityView, IBaseFragmentView,
        BaseFragment.OnFragmentListener {

    static final String TAG = BaseActivity.class.getSimpleName();

    public Typeface typefaceBold;

    public Typeface typefaceItalic;

    public Typeface typefaceLight;

    public Typeface typefaceMedium;

    public Typeface typefaceRegular;

    public Typeface typefaceThin;

    private MaterialDialog mMaterialDialog;

    private Toast mToast;

    private FragmentManager mFragmentManager;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createTypeface();

        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void createTypeface() {
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-Regular.ttf");

        typefaceBold    = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        typefaceItalic  = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Italic.ttf");
        typefaceLight   = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        typefaceMedium  = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        typefaceRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        typefaceThin    = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
    }

    @Override
    public void showDialogBasic(String title, String content,
                                String positive, final ICallback positiveCallback,
                                String negative, final ICallback negativeCallback,
                                String neutral, final ICallback neutralCallback) {
        dismissDialog();

        final MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .backgroundColorRes(R.color.colorWhite)
                .title(title)
                .titleColorRes(R.color.colorDialogTitle)
                .content(content)
                .contentColorRes(R.color.colorDialogContent);

        if (!TextUtils.isEmpty(positive)) {
            builder.positiveText(positive).positiveColorRes(R.color.colorDialogPositive);
            if (positiveCallback != null) {
                builder.onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog,
                                        @NonNull DialogAction which) {
                        positiveCallback.onAction(null);
                    }
                });
            }
        }

        if (!TextUtils.isEmpty(negative)) {
            builder.negativeText(negative).negativeColorRes(R.color.colorDialogNegative);
            if (negativeCallback != null) {
                builder.onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog,
                                        @NonNull DialogAction which) {
                        negativeCallback.onAction(null);
                    }
                });
            }
        }

        if (!TextUtils.isEmpty(neutral)) {
            builder.neutralText(neutral).neutralColorRes(R.color.colorDialogNeutral);
            if (neutralCallback != null) {
                builder.onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        neutralCallback.onAction(null);
                    }
                });
            }
        }

        mMaterialDialog = builder.show();
    }

    @Override
    public void showDialogBasic(String title, String content,
                                String positive, ICallback positiveCallback,
                                String negative, ICallback negativeCallback) {
        showDialogBasic(title, content,
                positive, positiveCallback,
                negative, negativeCallback,
                null, null);
    }

    @Override
    public void showDialogBasic(String title, String content,
                                String positive, ICallback positiveCallback,
                                String negative) {
        showDialogBasic(title, content,
                positive, positiveCallback,
                negative, null);
    }

    @Override
    public void showDialogBasic(String title, String content,
                                String positive, ICallback positiveCallback) {
        showDialogBasic(title, content,
                positive, positiveCallback,
                null);
    }

    @Override
    public void showDialogBasic(String title, String content, String positive) {
        showDialogBasic(title, content,
                positive, null);
    }

    @Override
    public void showDialogBasic(int title, int content,
                                int positive, ICallback positiveCallback,
                                int negative, ICallback negativeCallback,
                                int neutral, ICallback neutralCallback) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), positiveCallback,
                getString(negative), negativeCallback,
                getString(neutral), neutralCallback);
    }

    @Override
    public void showDialogBasic(int title, int content,
                                int positive, ICallback positiveCallback,
                                int negative, ICallback negativeCallback) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), positiveCallback,
                getString(negative), negativeCallback,
                null, null);

    }

    @Override
    public void showDialogBasic(int title, int content,
                                int positive, ICallback positiveCallback,
                                int negative) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), positiveCallback,
                getString(negative), null);
    }

    @Override
    public void showDialogBasic(int title, int content,
                                int positive, ICallback positiveCallback) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), positiveCallback,
                null);
    }

    @Override
    public void showDialogBasic(int title, int content,
                                int positive) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), null);
    }

    @Override
    public void showDialogProgress(String title, String content, boolean horizontal) {
        dismissDialog();

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .backgroundColorRes(R.color.colorWhite)
                .title(title)
                .titleColorRes(R.color.colorDialogTitle)
                .content(content)
                .contentColorRes(R.color.colorDialogContent)
                .progress(true, 0)
                .progressIndeterminateStyle(horizontal)
                .widgetColorRes(R.color.colorDialogProgress);

        mMaterialDialog = builder.show();
    }

    @Override
    public void showDialogProgressCircle(String title, String content) {
        showDialogProgress(title, content, false);
    }

    @Override
    public void showDialogProgressHorizontal(String title, String content) {
        showDialogProgress(title, content, true);
    }

    @Override
    public void showDialogProgress(int title, int content, boolean horizontal) {
        showDialogProgress(getString(title), getString(content), horizontal);
    }

    @Override
    public void showDialogProgressCircle(int title, int content) {
        showDialogProgress(title, content, false);
    }

    @Override
    public void showDialogProgressHorizontal(int title, int content) {
        showDialogProgress(title, content, true);
    }

    @Override
    public void dismissDialog() {
        if (mMaterialDialog != null) {
            mMaterialDialog.dismiss();
            mMaterialDialog = null;
        }
    }

    @Override
    public void hideDialog() {
        if (mMaterialDialog != null) {
            mMaterialDialog.hide();
        }
    }

    @Override
    public void showToast(final String message, final boolean isLongTime) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dismissToast();

                mToast = Toast.makeText(getApplicationContext(), message,
                        isLongTime ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
                mToast.setGravity(Gravity.CENTER, 0, 0);
                mToast.show();
            }
        });
    }

    @Override
    public void showToast(String message) {
        showToast(message, false);
    }

    @Override
    public void showToast(int message, boolean isLongTime) {
        showToast(getString(message), isLongTime);
    }

    @Override
    public void showToast(int message) {
        showToast(message, false);
    }

    @Override
    public void dismissToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    @Override
    public Fragment findingFragment(int layoutId) {
        return mFragmentManager.findFragmentById(layoutId);
    }

    @Override
    public Fragment findingFragment(String tag) {
        return mFragmentManager.findFragmentByTag(tag);
    }

    @Override
    public void showingFragment(Fragment fragment, @Nullable Bundle bundle,
                                @IdRes int idLayoutContainer, String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentTransaction.replace(idLayoutContainer, fragment, tag);

        fragmentTransaction.commit();
    }

    /**
     * Handle event multi fragment
     */
    @Override
    public void onFragmentAction(int layoutId, @Nullable int event) {

    }

    @Override
    protected void onStop() {
        dismissDialog();
        dismissToast();

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mFragmentManager = null;

        super.onDestroy();
    }
}
