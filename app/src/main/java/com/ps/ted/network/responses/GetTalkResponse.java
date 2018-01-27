package com.ps.ted.network.responses;

import com.google.gson.annotations.SerializedName;
import com.ps.ted.data.vo.TalkVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

public class GetTalkResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("ted_talks")
    private String talkList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

//    public List<TalkVO> getTalkList() {
//        if(talkList == null){
//            talkList = new ArrayList<>();
//        }
//
//        return talkList;
//    }

    public String getTalkList() {
        return talkList;
    }

    public void setTalkList(String talkList) {
        this.talkList = talkList;
    }
}
