package com.ps.ted.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.SearchResultAdapter;
import com.ps.ted.delegates.SearchResultDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchResultActivity extends BaseActivity implements SearchResultDelegate {

    @BindView(R.id.rv_search_result)
    RecyclerView rvSearchResult;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this, this);

        rvSearchResult.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(getApplicationContext(), this);
        rvSearchResult.setAdapter(searchResultAdapter);
    }

    @Override
    public void onTapSearchResult() {
        Toast.makeText(getApplicationContext(), "Search Result delegate tap", Toast.LENGTH_SHORT).show();
    }
}
