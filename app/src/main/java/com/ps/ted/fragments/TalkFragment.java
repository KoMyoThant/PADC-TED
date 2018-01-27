package com.ps.ted.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ps.ted.R;
import com.ps.ted.adapters.TalkAdapter;
import com.ps.ted.components.EmptyViewPod;
import com.ps.ted.components.SmartRecyclerView;
import com.ps.ted.data.model.TEDModel;
import com.ps.ted.delegates.TalkItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TalkFragment extends BaseFragment implements TalkItemDelegate {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;

    @BindView(R.id.vp_empty_talk)
    EmptyViewPod vpEmptyTalk;

    private TEDModel mTedModel;

    public TalkFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_talk, container, false);
        ButterKnife.bind(this, view);

        mTedModel = new TEDModel();
        mTedModel = ViewModelProviders.of(this).get(TEDModel.class);

        vpEmptyTalk.setEmptyData("Ha Ha No Data");
        rvTalks.setEmptyView(vpEmptyTalk);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        TalkAdapter talkAdapter = new TalkAdapter(getContext(), this);
        rvTalks.setAdapter(talkAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onTapTalk() {
        Toast.makeText(getContext(), "Talk delegate tap", Toast.LENGTH_SHORT).show();
    }
}
