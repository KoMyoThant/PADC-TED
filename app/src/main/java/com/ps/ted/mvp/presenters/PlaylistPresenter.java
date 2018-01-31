package com.ps.ted.mvp.presenters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.ps.ted.data.model.PlaylistModel;
import com.ps.ted.data.vo.PlaylistVO;
import com.ps.ted.delegates.PlaylistItemDelegate;
import com.ps.ted.mvp.views.PlaylistView;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public class PlaylistPresenter extends BasePresenter<PlaylistView> implements PlaylistItemDelegate {

    private PlaylistModel mPlaylistModel;
    private LifecycleOwner mLifecycleOwner;

    public PlaylistPresenter(LifecycleOwner lifecycleOwner, PlaylistModel playlistModel) {
        mLifecycleOwner = lifecycleOwner;
        mPlaylistModel = playlistModel;
    }

    @Override
    public void onStart() {
        mPlaylistModel.getPlaylists().observe(mLifecycleOwner, new Observer<List<PlaylistVO>>() {
            @Override
            public void onChanged(@Nullable List<PlaylistVO> playlistVOS) {
                if (!playlistVOS.isEmpty()) {
                    mView.displayPlaylistList(playlistVOS);
                } else {
                    mView.refreshPlaylistList();
                    mPlaylistModel.startLoadingPlaylists().observe(mLifecycleOwner, new Observer<List<PlaylistVO>>() {
                        @Override
                        public void onChanged(@Nullable List<PlaylistVO> playlistVOS) {
                            mView.displayPlaylistList(playlistVOS);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTapPlaylist() {

    }

    public void onNewsListEndReach(){
        mPlaylistModel.loadMorePlaylists();
    }
}
