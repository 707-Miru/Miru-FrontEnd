package com.back.miru.model.dto;

public class FavoritePicture {
    private int pictureIdx;
    private String filepath;
    private String tag;
    private int publicFlag;
    private String id;
    private String updateTime;

    public FavoritePicture(int pictureIdx, String filepath, String tag, int publicFlag, String id, String updateTime) {
        this.pictureIdx = pictureIdx;
        this.filepath = filepath;
        this.tag = tag;
        this.publicFlag = publicFlag;
        this.id = id;
        this.updateTime = updateTime;
    }

    public int getPictureIdx() {
        return pictureIdx;
    }

    public void setPictureIdx(int pictureIdx) {
        this.pictureIdx = pictureIdx;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(int publicFlag) {
        this.publicFlag = publicFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
