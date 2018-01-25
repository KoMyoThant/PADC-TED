package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pyaesone on 1/26/18.
 */

@Entity(tableName = "attractions")
public class TalkVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("talk_id")
    private long talkId;

    @SerializedName("title")
    private String title;

    @SerializedName("speaker")
    private SpeakerVO speaker;

    @SerializedName("imageUrl")
    private String image;

    @SerializedName("durationInSec")
    private long durationInSec;

    @SerializedName("description")
    private String description;

    @SerializedName("tag")
    private List<TagVO> tag;

    public long getId() {
        return id;
    }

    public long getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getImage() {
        return image;
    }

    public long getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTag() {
        return tag;
    }
}
