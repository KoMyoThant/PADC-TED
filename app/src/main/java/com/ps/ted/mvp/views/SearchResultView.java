package com.ps.ted.mvp.views;

import com.ps.ted.data.vo.SearchVO;

import java.util.List;

/**
 * Created by pyaesone on 1/31/18.
 */

public interface SearchResultView {

    void displaySearchResultList(List<SearchVO> searchResultList);

    void refreshSearchResultList();
}
