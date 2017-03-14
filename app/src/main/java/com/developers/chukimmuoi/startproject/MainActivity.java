package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.view.View;

import com.developers.chukimmuoi.startproject.listener.callback.ICallback;

import java.util.Objects;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showDialogBasic("title 1", "content 1", "positive 1", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("positive 1");
                    }
                }, "negative 1", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("negative 1", true);
                    }
                }, "neutral 1", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("neutral 1", false);
                    }
                });
                break;
            case R.id.button2:
                showDialogBasic("title 2", "content 2", "positive 2", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("positive 2", true);
                    }
                }, "negative 2", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("negative 2", false);
                    }
                });
                break;
            case R.id.button3:
                showDialogBasic("title 3", "content 3", "positive 3", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("positive 3", true);
                    }
                }, "negative 3");
                break;
            case R.id.button4:
                showDialogBasic("title 4", "content 4", "positive 4", new ICallback() {
                    @Override
                    public void onAction(Objects objects) {
                        showToast("positive 4", true);
                    }
                });
                break;
            case R.id.button5:
                showDialogBasic("title 5", "content 5", "positive 5");
                break;
            case R.id.button6:
                showDialogProgress("Download 6", "Loading...", true);
                break;
            case R.id.button7:
                showDialogProgress("Download 7", "Loading...", false);
                break;
            case R.id.button8:
                showDialogProgressCircle("Download 8", "Loading...");
                break;
            case R.id.button9:
                showDialogProgressCircle(null, "Loading...");
                break;
            case R.id.button10:
                showDialogProgressHorizontal("Download 10", "Loading...");
                break;
        }
    }
}
