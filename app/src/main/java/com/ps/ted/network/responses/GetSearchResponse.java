package com.ps.ted.network.responses;

import com.google.gson.annotations.SerializedName;
import com.ps.ted.data.vo.SearchVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

public class GetSearchResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("")
    private String searchList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

//    public List<SearchVO> getSearchList() {
//        if(searchList == null){
//            searchList = new ArrayList<>();
//        }
//
//        return searchList;
//    }
//
//    public void setSearchList(List<SearchVO> searchList) {
//        this.searchList = searchList;
//    }


    public String getSearchList() {
        return searchList;
    }

    public void setSearchList(String searchList) {
        this.searchList = searchList;
    }
}
