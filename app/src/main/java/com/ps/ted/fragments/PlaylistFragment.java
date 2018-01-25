package com.ps.ted.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.ps.ted.delegates.PlaylistItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PlaylistFragment extends BaseFragment implements PlaylistItemDelegate {

    @BindView(R.id.rv_playlist)
    SmartRecyclerView rvPlaylist;

    @BindView(R.id.vp_empty_playlist)
    EmptyViewPod vpEmptyPlaylist;

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

        vpEmptyPlaylist.setEmptyData("Ha Ha No Data");
        rvPlaylist.setEmptyView(vpEmptyPlaylist);
        rvPlaylist.setLayoutManager(new GridLayoutManager(getContext(), 2));
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(getContext(),this);
        rvPlaylist.setAdapter(playlistAdapter);

        return view;
    }

    @Override
    public void onTapPlaylist() {
        Toast.makeText(getContext(), "Playlist delegate tap", Toast.LENGTH_SHORT).show();
    }
}
