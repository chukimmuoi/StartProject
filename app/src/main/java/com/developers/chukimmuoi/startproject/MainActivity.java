package com.developers.chukimmuoi.startproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developers.chukimmuoi.shared.ui.recycler.BaseRecyclerView;
import com.developers.chukimmuoi.startproject.adapter.TestAdapter;
import com.developers.chukimmuoi.startproject.model.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rv_contact)
    BaseRecyclerView rvContact;

    TestAdapter mTestAdapter;
    ArrayList<? super Object> mListContact;
    @BindView(R.id.btn_insert1)
    Button btnInsert1;
    @BindView(R.id.btn_insert2)
    Button btnInsert2;
    @BindView(R.id.btn_update1)
    Button btnUpdate1;
    @BindView(R.id.btn_update2)
    Button btnUpdate2;
    @BindView(R.id.btn_remove1)
    Button btnRemove1;
    @BindView(R.id.btn_remove2)
    Button btnRemove2;
    @BindView(R.id.btn_moved)
    Button btnMoved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mListContact = Contact.createContactList(20);
        mTestAdapter = new TestAdapter(MainActivity.this, rvContact, mListContact);
        rvContact.setAdapter(mTestAdapter);
        rvContact.initLinearLayoutManager();
    }

    @OnClick({R.id.btn_insert1, R.id.btn_insert2,
            R.id.btn_update1, R.id.btn_update2,
            R.id.btn_remove1, R.id.btn_remove2,
            R.id.btn_moved})
    public void onViewClicked(View view) {
        int size = mTestAdapter.getItemCount();
        switch (view.getId()) {
            case R.id.btn_insert1:
                mTestAdapter.insertItem(size, new Contact("chukimmuoi", false));
                break;
            case R.id.btn_insert2:
                List<? super Object> addList = Contact.createContactList(10);
                mTestAdapter.insertItem(size, addList);
                break;
            case R.id.btn_update1:
                ((Contact) mListContact.get(size - 1)).setName("Trinh Thi Nhai");
                mTestAdapter.updateItem(size - 1);
                break;
            case R.id.btn_update2:
                for (int i = 10; i < 20; i++) {
                    ((Contact) mListContact.get(i)).setName("Trinh Thi Nhai " + i);
                }
                mTestAdapter.updateItem(10, 10);
                break;
            case R.id.btn_remove1:
                mTestAdapter.removeItem(0);
                break;
            case R.id.btn_remove2:
                mTestAdapter.removeItem(0, 10);
                break;
            case R.id.btn_moved:
                mTestAdapter.movedItem(3, 0);
                break;
        }
    }
}
