package com.ps.ted.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.delegates.SearchDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchActivity extends BaseActivity implements SearchDelegate, View.OnClickListener {

    @BindView(R.id.rl_search_recent_item_list)
    RelativeLayout rlSearchRecentItem;

    private SearchDelegate mSearchDelegate;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this, this);

        mSearchDelegate = this;
        rlSearchRecentItem.setOnClickListener(this);
    }

    @Override
    public void onTapSearch() {
        Toast.makeText(getApplicationContext(), "Search delegate tap", Toast.LENGTH_SHORT).show();
        //TODO to inflate search result activity
//        Intent searchResultIntent = SearchResultActivity.newIntent(getApplicationContext());
//        startActivity(searchResultIntent);
    }

    @Override
    public void onClick(View view) {
//        mSearchDelegate.onTapSearch();
        Intent searchResultIntent = SearchResultActivity.newIntent(getApplicationContext());
        startActivity(searchResultIntent);
    }
}
