package com.ps.ted.mvp.presenters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.ps.ted.data.model.SearchResultModel;
import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.delegates.SearchDelegate;
import com.ps.ted.delegates.SearchResultDelegate;
import com.ps.ted.mvp.views.SearchResultView;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class SearchResultPresenter extends BasePresenter<SearchResultView> implements SearchResultDelegate {

    private SearchResultModel mSearchResultModel;
    private LifecycleOwner mLifecycleOwner;

    public SearchResultPresenter(LifecycleOwner lifecycleOwner, SearchResultModel searchResultModel) {
        mLifecycleOwner = lifecycleOwner;
        mSearchResultModel = searchResultModel;
    }

    @Override
    public void onStart() {
        mSearchResultModel.getSearchResultList().observe(mLifecycleOwner, new Observer<List<SearchVO>>() {
            @Override
            public void onChanged(@Nullable List<SearchVO> searchVOS) {
                if (!searchVOS.isEmpty()) {
                    mView.displaySearchResultList(searchVOS);
                } else {
                    mView.refreshSearchResultList();
                    mSearchResultModel.startLoadingSearchResultList().observe(mLifecycleOwner, new Observer<List<SearchVO>>() {
                        @Override
                        public void onChanged(@Nullable List<SearchVO> searchVOS) {
                            mView.displaySearchResultList(searchVOS);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onStop() {

    }

    public void onNewsListEndReach() {
        mSearchResultModel.loadMoreSearchResultLists();
    }

    @Override
    public void onTapSearchResult() {

    }
}
