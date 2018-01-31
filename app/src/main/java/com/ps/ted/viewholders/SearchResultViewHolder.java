package com.ps.ted.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ps.ted.R;
import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.delegates.SearchDelegate;
import com.ps.ted.delegates.SearchResultDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/25/18.
 */

public class SearchResultViewHolder extends BaseViewHolder<SearchVO>{

    @BindView(R.id.iv_search_placeholder_image)
    ImageView ivSearchResultHeroImg;

    @BindView(R.id.tv_search_duration)
    TextView tvSearchDuration;

    @BindView(R.id.tv_search_speaker_name)
    TextView tvSearchSpeakerName;

    @BindView(R.id.tv_search_title)
    TextView tvSearchTitle;

    private SearchResultDelegate mSearchResultDelegate;

    public SearchResultViewHolder(View itemView, SearchResultDelegate searchResultDelegate) {
        super(itemView);
        mSearchResultDelegate = searchResultDelegate;
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(SearchVO data) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.img_placeholder)
                .centerCrop();

        tvSearchDuration.setText("15:00");
        tvSearchTitle.setText(data.getTitle());

        Glide.with(itemView.getContext())
                .load(data.getImage())
                .apply(requestOptions)
                .into(ivSearchResultHeroImg);
    }

    @Override
    public void onClick(View view) {
        mSearchResultDelegate.onTapSearchResult();
    }
}
