package com.ps.ted.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.ps.ted.TEDApp;
import com.ps.ted.data.vo.PlaylistVO;
import com.ps.ted.network.responses.GetPlaylistResponse;
import com.ps.ted.utils.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pyaesone on 1/31/18.
 */

public class PlaylistModel extends BaseModel {

    //TODO to delete
    public MutableLiveData<List<PlaylistVO>> playlistList;

    public PlaylistModel() {
        super();
        playlistList = new MutableLiveData<>();
    }

    public LiveData<List<PlaylistVO>> getPlaylists() {
        return mAppDatabase.playlistDao().getAllPlaylists();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<PlaylistVO>> startLoadingPlaylists() {
        return loadPlaylists(AppConstants.ACCESS_TOKEN, configUtils.loadPlaylistPageIndex());
    }

    public LiveData<List<PlaylistVO>> loadPlaylists(String accessToken, int pageNo) {
        Observable<GetPlaylistResponse> playlistResponseObservable = retrofitDataAgent.getTEDApi().loadTEDPlaylists(accessToken, pageNo);
        playlistResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetPlaylistResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetPlaylistResponse getPlaylistResponse) {
                        playlistList.setValue(getPlaylistResponse.getPlaylistList());
                        configUtils.savePlaylistPageIndex(getPlaylistResponse.getPageNo() + 1);

                        Log.d(TEDApp.LOG_TAG, "playlistList size onNext : " + playlistList.getValue().size());

                        long[] insertedIds = mAppDatabase.playlistDao().insertPlaylists(getPlaylistResponse.getPlaylistList().toArray(new PlaylistVO[0]));
                        Log.d(TEDApp.LOG_TAG, "insertedIds playlists : " + insertedIds.length);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return playlistList;

    }

    public LiveData<List<PlaylistVO>> loadMorePlaylists(){
        return loadPlaylists(AppConstants.ACCESS_TOKEN, configUtils.loadPlaylistPageIndex());
    }
}
