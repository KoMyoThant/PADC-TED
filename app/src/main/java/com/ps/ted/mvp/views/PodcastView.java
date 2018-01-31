package com.ps.ted.mvp.views;


import com.ps.ted.data.vo.PodcastVO;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public interface PodcastView {
    void displayPodcastList(List<PodcastVO> podcastList);

    void refreshPodcastList();
}
