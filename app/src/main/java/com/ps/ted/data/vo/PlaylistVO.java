package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Entity(tableName = "playlist")
public class PlaylistVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("playlist_id")
    private long playlistId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String image;

    @SerializedName("totalTalks")
    private int totalTalks;

    @SerializedName("description")
    private String description;

    @SerializedName("talksInPlaylist")
    private String talksInPlaylist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(long playlistId) {
        this.playlistId = playlistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public void setTotalTalks(int totalTalks) {
        this.totalTalks = totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<TalkVO> getTalksInPlaylist() {
//        return talksInPlaylist;
//    }
//
//    public void setTalksInPlaylist(List<TalkVO> talksInPlaylist) {
//        this.talksInPlaylist = talksInPlaylist;
//    }


    public String getTalksInPlaylist() {
        return talksInPlaylist;
    }

    public void setTalksInPlaylist(String talksInPlaylist) {
        this.talksInPlaylist = talksInPlaylist;
    }
}
