package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListContact = Contact.createContactsList(10, 0);
        mTestAdapter = new TestAdapter(MainActivity.this, rvContact, mListContact);
        rvContact.setAdapter(mTestAdapter);
        rvContact.initLinearLayoutManager();
        rvContact.setOnEndlessScrolling(this);
    }

    @Override
    public void loadNextPage(int page, int totalItemsCount, RecyclerView view) {
        List<? super Object> moreContacts = Contact.createContactsList(9, page);
        int curSize = mTestAdapter.getItemCount();
        view.post(() -> mTestAdapter.insertItem(curSize, moreContacts));
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
