package com.ps.ted.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.ps.ted.TEDApp;
import com.ps.ted.data.vo.SearchVO;
import com.ps.ted.network.responses.GetSearchResponse;
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

public class SearchResultModel extends BaseModel {



    //TODO to delete
    public MutableLiveData<List<SearchVO>> searchResultList;

    public SearchResultModel() {
        super();
        searchResultList = new MutableLiveData<>();
    }

    public LiveData<List<SearchVO>> getSearchResultList() {
        return mAppDatabase.searchDao().getAllSearchs();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<SearchVO>> startLoadingSearchResultList() {
        return loadSearchResultList(AppConstants.ACCESS_TOKEN, configUtils.loadSearchResultPageIndex());
    }

    public LiveData<List<SearchVO>> loadSearchResultList(String accessToken, int pageNo) {
        Observable<GetSearchResponse> searchResultResponseObservable = retrofitDataAgent.getTEDApi().loadTEDSearchs(accessToken, pageNo);
        searchResultResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetSearchResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetSearchResponse getSearchResponse) {
                        searchResultList.setValue(getSearchResponse.getSearchList());
                        configUtils.saveSearchResultPageIndex(getSearchResponse.getPageNo() + 1);

                        Log.d(TEDApp.LOG_TAG, "searchResultList size onNext : " + searchResultList.getValue().size());

                        long[] insertedIds = mAppDatabase.searchDao().insertSearchs(getSearchResponse.getSearchList().toArray(new SearchVO[0]));
                        Log.d(TEDApp.LOG_TAG, "insertedIds searchresults : " + insertedIds.length);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return searchResultList;

    }

    public LiveData<List<SearchVO>> loadMoreSearchResultLists(){
        return loadSearchResultList(AppConstants.ACCESS_TOKEN, configUtils.loadSearchResultPageIndex());
    }
}
