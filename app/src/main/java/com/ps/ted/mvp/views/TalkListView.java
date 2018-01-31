package com.ps.ted.mvp.views;

import com.ps.ted.data.vo.TalkVO;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public interface TalkListView {

    void displayTalkList(List<TalkVO> talkList);

    void refreshTalkList();
}
