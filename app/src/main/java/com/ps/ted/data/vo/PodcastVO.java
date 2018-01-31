package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.ps.ted.data.db.SegmentTypeConvector;

import java.util.List;

/**
 * Created by pyaesone on 1/27/18.
 */

@Entity(tableName = "podcast")
@TypeConverters({SegmentTypeConvector.class})
public class PodcastVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("podcast_id")
    private long podcastId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String image;

    @SerializedName("description")
    private String description;

    @SerializedName("segments")
    private List<SegmentVO> segmentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(long podcastId) {
        this.podcastId = podcastId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SegmentVO> getSegmentList() {
        return segmentList;
    }

    public void setSegmentList(List<SegmentVO> segmentList) {
        this.segmentList = segmentList;
    }
}
