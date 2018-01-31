package com.ps.ted.activities;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.SearchResultAdapter;
import com.ps.ted.components.EmptyViewPod;
import com.ps.ted.components.SmartRecyclerView;
import com.ps.ted.components.SmartScrollListener;
import com.ps.ted.data.model.SearchResultModel;
import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.delegates.SearchResultDelegate;
import com.ps.ted.mvp.presenters.SearchResultPresenter;
import com.ps.ted.mvp.views.SearchResultView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchResultActivity extends BaseActivity implements SearchResultView {

    @BindView(R.id.rv_search_result)
    SmartRecyclerView rvSearchResult;

    @BindView(R.id.vp_empty_search_result)
    EmptyViewPod vpEmptySearchResult;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private SearchResultAdapter searchResultAdapter;

    private SearchResultModel mSearchResultModel;

    private SearchResultPresenter mPresenter;

    private SmartScrollListener mSmartScrollListener;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this, this);

        mSearchResultModel = ViewModelProviders.of(this).get(SearchResultModel.class);
        mSearchResultModel.initDatabase(getApplicationContext());

        mPresenter = new SearchResultPresenter(this, mSearchResultModel);
        mPresenter.onCreate(this);

        vpEmptySearchResult.setEmptyData("Ha Ha No Data");
        rvSearchResult.setEmptyView(vpEmptySearchResult);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        searchResultAdapter = new SearchResultAdapter(getApplicationContext(),mPresenter);
        rvSearchResult.setAdapter(searchResultAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                mPresenter.onNewsListEndReach();
            }
        });
        rvSearchResult.addOnScrollListener(mSmartScrollListener);
    }

//    @Override
//    public void onTapSearchResult() {
//        Toast.makeText(getApplicationContext(), "Search Result delegate tap", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void displaySearchResultList(List<SearchVO> searchResultList) {
        searchResultAdapter.setNewData(searchResultList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshSearchResultList() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
