package com.ps.ted.mvp.views;

import com.ps.ted.data.vo.PlaylistVO;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public interface PlaylistView {

    void displayPlaylistList(List<PlaylistVO> podcastList);

    void refreshPlaylistList();
}
