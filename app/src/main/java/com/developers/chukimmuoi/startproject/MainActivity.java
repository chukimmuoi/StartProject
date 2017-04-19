package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerView;
import com.developers.chukimmuoi.shared.ui.recycler.model.LoadMoreObject;
import com.developers.chukimmuoi.startproject.adapter.TestAdapter;
import com.developers.chukimmuoi.startproject.model.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BaseRecyclerView.OnEndlessScrolling {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rv_contact)
    BaseRecyclerView rvContact;

    TestAdapter mTestAdapter;
    ArrayList<? super Object> mListContact;
    @BindView(R.id.btn_test)
    Button btnTest;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListContact = Contact.createContactsList(10, 0);
        mTestAdapter = new TestAdapter(MainActivity.this, rvContact, mListContact);
        rvContact.setAdapter(mTestAdapter);
        rvContact.initLayoutManager(BaseRecyclerView.STAGGERED_GRID_LAYOUT, 2, false, false);
        rvContact.setOnEndlessScrolling(this);
        rvContact.setHasFixedSize(true);
    }

    @Override
    public void loadNextPage(int page, int totalItemsCount, RecyclerView view) {
        int size = mListContact.size();
        if (mListContact.get(size - 1) instanceof LoadMoreObject) {
            return;
        }
        mTestAdapter.insertItem(size, new LoadMoreObject());

        mHandler.postDelayed(() -> {
            int size1 = mListContact.size();
            mTestAdapter.removeItem(size1 - 1);

            List<? super Object> moreContacts = Contact.createContactsList(10, page);
            int curSize = mTestAdapter.getItemCount();
            mTestAdapter.insertItem(curSize, moreContacts);
        }, 1 * 1000);
    }

    @Override
    public void resetEndless() {
        mListContact.clear();
        mTestAdapter.reloadAll();
        rvContact.resetStateEndless();
    }

    @OnClick(R.id.btn_test)
    public void onViewClicked() {
        resetEndless();
    }
}
