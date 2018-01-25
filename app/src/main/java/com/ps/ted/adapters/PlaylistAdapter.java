package com.ps.ted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.ted.R;
import com.ps.ted.delegates.PlaylistItemDelegate;
import com.ps.ted.viewholders.PlaylistViewHolder;

/**
 * Created by pyaesone on 1/24/18.
 */

public class PlaylistAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private PlaylistItemDelegate mPlaylistItemDelegate;

    public PlaylistAdapter(Context context, PlaylistItemDelegate playlistItemDelegate) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mPlaylistItemDelegate = playlistItemDelegate;
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_playlist, parent, false);

        return new PlaylistViewHolder(view, mPlaylistItemDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
