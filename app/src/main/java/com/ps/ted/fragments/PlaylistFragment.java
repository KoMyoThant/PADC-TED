package com.ps.ted.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.PlaylistAdapter;
import com.ps.ted.components.EmptyViewPod;
import com.ps.ted.components.SmartRecyclerView;
import com.ps.ted.components.SmartScrollListener;
import com.ps.ted.data.model.PlaylistModel;
import com.ps.ted.data.model.TEDModel;
import com.ps.ted.data.vo.PlaylistVO;
import com.ps.ted.delegates.PlaylistItemDelegate;
import com.ps.ted.mvp.presenters.PlaylistPresenter;
import com.ps.ted.mvp.presenters.TalkListPresenter;
import com.ps.ted.mvp.views.PlaylistView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PlaylistFragment extends BaseFragment implements PlaylistView {

    @BindView(R.id.rv_playlist)
    SmartRecyclerView rvPlaylist;

    @BindView(R.id.vp_empty_playlist)
    EmptyViewPod vpEmptyPlaylist;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PlaylistModel mPlaylistModel;

    private PlaylistAdapter playlistAdapter;

    private PlaylistPresenter mPresenter;

    private SmartScrollListener mSmartScrollListener;

    public PlaylistFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_playlist, container, false);
        ButterKnife.bind(this, view);

        mPlaylistModel = ViewModelProviders.of(this).get(PlaylistModel.class);
        mPlaylistModel.initDatabase(getContext());

        mPresenter = new PlaylistPresenter(this,mPlaylistModel);
        mPresenter.onCreate(this);

        vpEmptyPlaylist.setEmptyData("Ha Ha No Data");
        rvPlaylist.setEmptyView(vpEmptyPlaylist);
        rvPlaylist.setLayoutManager(new GridLayoutManager(getContext(), 2));
        playlistAdapter = new PlaylistAdapter(getContext(), mPresenter);
        rvPlaylist.setAdapter(playlistAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                mPresenter.onNewsListEndReach();
            }
        });
        rvPlaylist.addOnScrollListener(mSmartScrollListener);

        return view;
    }

//    @Override
//    public void onTapPlaylist() {
//        Toast.makeText(getContext(), "Playlist delegate tap", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void displayPlaylistList(List<PlaylistVO> talkList) {
        playlistAdapter.setNewData(talkList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshPlaylistList() {
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
        mPresenter.onResume();
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
