package com.developers.chukimmuoi.startproject.view;

import com.developers.chukimmuoi.startproject.listener.callback.ICallback;

/**
 * @author : Hanet Electronics
 * @Skype : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : StartProject
 * Created by chukimmuoi on 3/12/17.
 */

public interface IBaseActivityView {
    void createTypeface();

    void showDialogBasic(String title, String content,
                         String positive, ICallback positiveCallback,
                         String negative, ICallback negativeCallback,
                         String neutral, ICallback neutralCallback);

    void showDialogBasic(String title, String content,
                         String positive, ICallback positiveCallback,
                         String negative, ICallback negativeCallback);

    void showDialogBasic(String title, String content,
                         String positive, ICallback positiveCallback,
                         String negative);

    void showDialogBasic(String title, String content,
                         String positive, ICallback positiveCallback);

    void showDialogBasic(String title, String content,
                         String positive);

    void showDialogBasic(int title, int content,
                         int positive, ICallback positiveCallback,
                         int negative, ICallback negativeCallback,
                         int neutral, ICallback neutralCallback);

    void showDialogBasic(int title, int content,
                         int positive, ICallback positiveCallback,
                         int negative, ICallback negativeCallback);

    void showDialogBasic(int title, int content,
                         int positive, ICallback positiveCallback,
                         int negative);

    void showDialogBasic(int title, int content,
                         int positive, ICallback positiveCallback);

    void showDialogBasic(int title, int content,
                         int positive);

    void showDialogProgress(String title, String content, boolean horizontal);

    void showDialogProgressCircle(String title, String content);

    void showDialogProgressHorizontal(String title, String content);

    void showDialogProgress(int title, int content, boolean horizontal);

    void showDialogProgressCircle(int title, int content);

    void showDialogProgressHorizontal(int title, int content);

    void dismissDialog();

    void hideDialog();

    void showToast(String message, boolean isLongTime);

    void showToast(String message);

    void showToast(int message, boolean isLongTime);

    void showToast(int message);

    void dismissToast();
}
