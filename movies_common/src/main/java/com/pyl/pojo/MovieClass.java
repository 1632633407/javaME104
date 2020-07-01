package com.pyl.pojo;

import java.io.Serializable;

/**
 * @author admin
 * @date 2019/9/28
 * Use for 电影类别实体类
 */
public class MovieClass implements Serializable {
    private Integer id;
    private String mId;
    private String mName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
