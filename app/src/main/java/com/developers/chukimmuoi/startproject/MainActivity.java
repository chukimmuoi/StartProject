package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerView;
import com.developers.chukimmuoi.shared.ui.recycler.model.LoadMoreObject;
import com.developers.chukimmuoi.shared.ui.swipe.BaseSwipeRefreshLayout;
import com.developers.chukimmuoi.startproject.adapter.TestAdapter;
import com.developers.chukimmuoi.startproject.listener.onclick.OnItemClickListener;
import com.developers.chukimmuoi.startproject.model.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements BaseRecyclerView.OnEndlessScrolling, OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rv_contact)
    BaseRecyclerView rvContact;

    @BindView(R.id.btn_test)
    Button btnTest;

    @BindView(R.id.swipeContainer)
    BaseSwipeRefreshLayout swipeContainer;

    TestAdapter mTestAdapter;
    ArrayList<? super Object> mListContact;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListContact = Contact.createContactsList(10, 0);
        mTestAdapter = new TestAdapter(MainActivity.this, rvContact, mListContact);
        mTestAdapter.setListener(this);

        rvContact.setAdapter(mTestAdapter);
        rvContact.initLayoutManager(BaseRecyclerView.LINEAR_LAYOUT, 0, false, false);
        rvContact.setOnEndlessScrolling(this);
        rvContact.setHasFixedSize(true);
        rvContact.setItemAnimator(new DefaultItemAnimator());
//        rvContact.addOnItemTouchListener(new OnItemRecyclerClickListener(MainActivity.this, rvContact, new OnItemRecyclerClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                showToast("Item click position = " + position);
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//                showToast("Long item click position = " + position);
//            }
//        }));

        rvContact.setLinearSnapHelper(Gravity.BOTTOM);

//        ItemRecyclerClickSupport.addTo(rvContact).setOnItemClickListener((recyclerView, position, v) -> {
//            showToast("Item click position = " + position);
//        });
//        ItemRecyclerClickSupport.addTo(rvContact).setOnItemLongClickListener((recyclerView, position, v) -> {
//            showToast("Long item click position = " + position);
//            return true;
//        });

        swipeContainer.setOnRefreshListener(() -> {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeContainer.setRefreshing(false);
                }
            }, 3000);
        });
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

    @Override
    public void onItemClick(String className, View itemView, int position) {
        if (className.equals(mTestAdapter.getClass().getName())) {
            showToast("===> position = " + position);
        }
    }
}
