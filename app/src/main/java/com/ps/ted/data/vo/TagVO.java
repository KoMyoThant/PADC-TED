package com.ps.ted.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyaesone on 1/26/18.
 */

@Entity(tableName = "tag")
public class TagVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("tag_id")
    private long tagId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String description;

    public long getId() {
        return id;
    }

    public long getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
