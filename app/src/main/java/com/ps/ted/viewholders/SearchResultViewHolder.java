package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.delegates.SearchDelegate;
import com.ps.ted.delegates.SearchResultDelegate;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchResultViewHolder extends BaseViewHolder<SearchVO>{

    private SearchResultDelegate mSearchResultDelegate;

    public SearchResultViewHolder(View itemView, SearchResultDelegate searchResultDelegate) {
        super(itemView);
        mSearchResultDelegate = searchResultDelegate;
    }

    @Override
    public void setData(SearchVO data) {

    }

    @Override
    public void onClick(View view) {
        mSearchResultDelegate.onTapSearchResult();
    }
}
