package com.ps.ted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.ted.R;
import com.ps.ted.delegates.SearchDelegate;
import com.ps.ted.delegates.SearchResultDelegate;
import com.ps.ted.viewholders.SearchResultViewHolder;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchResultAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private SearchResultDelegate mSearchResultDelegate;

    public SearchResultAdapter(Context context, SearchResultDelegate searchResultDelegate) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mSearchResultDelegate = searchResultDelegate;
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_search_result, parent, false);

        return new SearchResultViewHolder(view, mSearchResultDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
