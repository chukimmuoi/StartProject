package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.developers.chukimmuoi.startproject.fragment.AFragment;
import com.developers.chukimmuoi.startproject.fragment.BFragment;
import com.developers.chukimmuoi.startproject.fragment.CFragment;
import com.developers.chukimmuoi.startproject.fragment.TestFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        displayFragment(R.id.fragment_frame_layout,
//                TestFragment.class.getName(), TestFragment.class.getCanonicalName(), false);

        displayMultiFragment(R.id.fragment_frame_layout, new TestFragment(),
                TestFragment.class.getCanonicalName(), null, null);
    }

    @Override
    public void onFragmentAction(int layoutId, @Nullable int event) {
        super.onFragmentAction(layoutId, event);

        switch (layoutId) {
            case R.layout.fragment_a:
                actionFragmentA(event);
                break;
            case R.layout.fragment_b:
                actionFragmentB(event);
                break;
            case R.layout.fragment_c:
                actionFragmentC(event);
                break;
        }
    }

    private void actionFragmentA(int event) {
        if (event == AFragment.EVENT_A1) {
            Bundle bundle = new Bundle();
            bundle.putString(AFragment.VALUE_TITLE_A, "A 1");
            bundle.putString(AFragment.VALUE_MESSAGE_A, "Message A 1");

            displayFragment(R.id.fragment_frame_layout, new AFragment(),
                    AFragment.class.getCanonicalName(), false, bundle);
        } else if (event == AFragment.EVENT_A2) {
            Bundle bundle = new Bundle();
            bundle.putString(AFragment.VALUE_TITLE_A, "A 2");
            bundle.putString(AFragment.VALUE_MESSAGE_A, "Message A 2");

            displayFragment(R.id.fragment_frame_layout, new AFragment(),
                    AFragment.class.getCanonicalName(), true, bundle);
        } else if (event == AFragment.EVENT_A3) {
            Bundle bundle = new Bundle();
            bundle.putString(AFragment.VALUE_TITLE_A, "A 3");
            bundle.putString(AFragment.VALUE_MESSAGE_A, "Message A 3");

            displayFragment(R.id.fragment_frame_layout, new AFragment(),
                    AFragment.class.getCanonicalName(), true, bundle);
        } else if (event == AFragment.EVENT_A4) {
            backStackFragment();
        }
    }

    private void actionFragmentB(int event) {
        if (event == BFragment.EVENT_B1) {
            Bundle bundle = new Bundle();
            bundle.putString(BFragment.VALUE_TITLE_B, "B 1");
            bundle.putString(BFragment.VALUE_MESSAGE_B, "Message B 1");

            displayMultiFragment(R.id.fragment_frame_layout, new BFragment(),
                    BFragment.class.getCanonicalName(), TestFragment.class.getCanonicalName(),
                    bundle);
        } else if (event == BFragment.EVENT_B2) {
            Bundle bundle = new Bundle();
            bundle.putString(BFragment.VALUE_TITLE_B, "B 2");
            bundle.putString(BFragment.VALUE_MESSAGE_B, "Message B 2");

            displayMultiFragment(R.id.fragment_frame_layout, new BFragment(),
                    BFragment.class.getCanonicalName(), TestFragment.class.getCanonicalName(),
                    bundle);
        } else if (event == BFragment.EVENT_B3) {
            Bundle bundle = new Bundle();
            bundle.putString(BFragment.VALUE_TITLE_B, "B 3");
            bundle.putString(BFragment.VALUE_MESSAGE_B, "Message B 3");

            displayMultiFragment(R.id.fragment_frame_layout, new BFragment(),
                    BFragment.class.getCanonicalName(), TestFragment.class.getCanonicalName(),
                    bundle);
        } else if (event == BFragment.EVENT_B4) {
            Bundle bundle = new Bundle();
            bundle.putString(BFragment.VALUE_TITLE_B, "B 2");
            bundle.putString(BFragment.VALUE_MESSAGE_B, "Message B 2");

            displayMultiFragment(R.id.fragment_frame_layout, new BFragment(),
                    BFragment.class.getCanonicalName(), TestFragment.class.getCanonicalName(),
                    bundle);
        }
    }

    private void actionFragmentC(int event) {
        if (event == CFragment.EVENT_C1) {
            Bundle bundle = new Bundle();
            bundle.putString(CFragment.VALUE_TITLE_C, "C 1");
            bundle.putString(CFragment.VALUE_MESSAGE_C, "Message C 1");
        } else if (event == CFragment.EVENT_C2) {
            Bundle bundle = new Bundle();
            bundle.putString(CFragment.VALUE_TITLE_C, "C 2");
            bundle.putString(CFragment.VALUE_MESSAGE_C, "Message C 2");
        } else if (event == CFragment.EVENT_C3) {
            Bundle bundle = new Bundle();
            bundle.putString(CFragment.VALUE_TITLE_C, "C 3");
            bundle.putString(CFragment.VALUE_MESSAGE_C, "Message C 3");
        }
    }
}
