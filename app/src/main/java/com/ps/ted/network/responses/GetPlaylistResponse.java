package com.ps.ted.network.responses;

import com.google.gson.annotations.SerializedName;
import com.ps.ted.data.vo.PlaylistVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

public class GetPlaylistResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("ted_playlists")
    private List<PlaylistVO> playlistList;

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

    public void setPlaylistList(List<PlaylistVO> playlistList) {
        this.playlistList = playlistList;
    }

    public List<PlaylistVO> getPlaylistList() {
        if (playlistList == null) {
            playlistList = new ArrayList<>();
        }

        return playlistList;
    }
}
