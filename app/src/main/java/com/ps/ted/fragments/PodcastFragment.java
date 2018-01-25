package com.ps.ted.fragments;

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
import com.ps.ted.adapters.PodcastAdapter;
import com.ps.ted.delegates.PodcastItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PodcastFragment extends BaseFragment implements PodcastItemDelegate {

    @BindView(R.id.rv_podcast)
    RecyclerView rvPodcasts;

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

        rvPodcasts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        PodcastAdapter podcastAdapter = new PodcastAdapter(getContext(), this);
        rvPodcasts.setAdapter(podcastAdapter);

        return view;
    }

    @Override
    public void onTapPodcast() {
        Toast.makeText(getContext(), "Podcast delegate tap", Toast.LENGTH_SHORT).show();
    }
}
