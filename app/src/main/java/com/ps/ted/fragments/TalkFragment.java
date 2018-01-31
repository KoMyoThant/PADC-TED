package com.ps.ted.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.TalkAdapter;
import com.ps.ted.components.EmptyViewPod;
import com.ps.ted.components.SmartRecyclerView;
import com.ps.ted.components.SmartScrollListener;
import com.ps.ted.data.model.TEDModel;
import com.ps.ted.data.vo.TalkVO;
import com.ps.ted.delegates.TalkItemDelegate;
import com.ps.ted.mvp.presenters.TalkListPresenter;
import com.ps.ted.mvp.views.TalkListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TalkFragment extends BaseFragment implements TalkListView {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;

    @BindView(R.id.vp_empty_talk)
    EmptyViewPod vpEmptyTalk;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private TEDModel mTedModel;

    private TalkAdapter talkAdapter;

    private TalkListPresenter mPresenter;

    private SmartScrollListener mSmartScrollListener;

    public TalkFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_talk, container, false);
        ButterKnife.bind(this, view);

        // mTedModel = new TEDModel();
        mTedModel = ViewModelProviders.of(this).get(TEDModel.class);
        mTedModel.initDatabase(getContext());

        mPresenter = new TalkListPresenter(this,mTedModel);
        mPresenter.onCreate(this);

        vpEmptyTalk.setEmptyData("Ha Ha No Data");
        rvTalks.setEmptyView(vpEmptyTalk);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        talkAdapter = new TalkAdapter(getContext(), mPresenter);
        rvTalks.setAdapter(talkAdapter);


        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                mPresenter.onNewsListEndReach();
            }
        });
        rvTalks.addOnScrollListener(mSmartScrollListener);

        return view;
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

    @Override
    public void displayTalkList(List<TalkVO> talkList) {
        talkAdapter.setNewData(talkList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshTalkList() {
        swipeRefreshLayout.setRefreshing(true);
    }
}
