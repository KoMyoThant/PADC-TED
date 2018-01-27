package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyaesone on 1/27/18.
 */

@Entity(tableName = "segment")
public class SegmentVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("segment_id")
    private long segmentId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(long segmentId) {
        this.segmentId = segmentId;
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
}
