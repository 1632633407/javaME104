package com.pyl.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date 2019/9/28
 * Use for 日志记录实体类
 */
public class Log implements Serializable {
    private Integer id;
    private String uName;
    private String option;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
