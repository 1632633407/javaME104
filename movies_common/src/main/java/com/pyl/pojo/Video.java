package com.pyl.pojo;

import java.io.Serializable;

/**
 * @author admin
 * @date 2019/9/28
 * Use for 电影实体类
 */
public class Video implements Serializable {
    private Integer id;
    private String vName;
    private String vId;
    private String vUrl;
    private String vImg;
    private String vInfo;
    private Integer vCount;
    private String mName;
    private String isVip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvUrl() {
        return vUrl;
    }

    public void setvUrl(String vUrl) {
        this.vUrl = vUrl;
    }

    public String getvImg() {
        return vImg;
    }

    public void setvImg(String vImg) {
        this.vImg = vImg;
    }

    public String getvInfo() {
        return vInfo;
    }

    public void setvInfo(String vInfo) {
        this.vInfo = vInfo;
    }

    public Integer getvCount() {
        return vCount;
    }

    public void setvCount(Integer vCount) {
        this.vCount = vCount;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }
}
