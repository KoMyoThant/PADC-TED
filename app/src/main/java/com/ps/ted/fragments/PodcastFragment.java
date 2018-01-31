package com.ps.ted.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.PodcastAdapter;
import com.ps.ted.components.EmptyViewPod;
import com.ps.ted.components.SmartRecyclerView;
import com.ps.ted.components.SmartScrollListener;
import com.ps.ted.data.model.PlaylistModel;
import com.ps.ted.data.model.PodcastModel;
import com.ps.ted.data.vo.PodcastVO;
import com.ps.ted.delegates.PodcastItemDelegate;
import com.ps.ted.mvp.presenters.PlaylistPresenter;
import com.ps.ted.mvp.presenters.PodcastListPresenter;
import com.ps.ted.mvp.views.PodcastView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PodcastFragment extends BaseFragment implements PodcastView {

    @BindView(R.id.rv_podcast)
    SmartRecyclerView rvPodcasts;

    @BindView(R.id.vp_empty_podcast)
    EmptyViewPod vpEmptyPodcast;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PodcastModel mPodcastModel;

    private PodcastListPresenter mPresenter;

    private PodcastAdapter podcastAdapter;

    private SmartScrollListener mSmartScrollListener;

    public PodcastFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_podcast, container, false);
        ButterKnife.bind(this, view);

        mPodcastModel = ViewModelProviders.of(this).get(PodcastModel.class);
        mPodcastModel.initDatabase(getContext());

        mPresenter = new PodcastListPresenter(this, mPodcastModel);
        mPresenter.onCreate(this);

        vpEmptyPodcast.setEmptyData("Ha Ha No Data");
        rvPodcasts.setEmptyView(vpEmptyPodcast);
        rvPodcasts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        podcastAdapter = new PodcastAdapter(getContext(), mPresenter);
        rvPodcasts.setAdapter(podcastAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                mPresenter.onNewsListEndReach();
            }
        });
        rvPodcasts.addOnScrollListener(mSmartScrollListener);

        return view;
    }

//    @Override
//    public void onTapPodcast() {
//        Toast.makeText(getContext(), "Podcast delegate tap", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void displayPodcastList(List<PodcastVO> podcastList) {
        podcastAdapter.setNewData(podcastList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshPodcastList() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
