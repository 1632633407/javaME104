package com.pyl.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date 2019/9/28
 * Use for 用户实体类
 */
public class User implements Serializable {
    private Integer id;
    private String uName;
    private String uPwd;
    private String uQQ;
    private String uEmail;
    private String uSex;
    private String uStauts;
    private Date uLoginTime;

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

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuQQ() {
        return uQQ;
    }

    public void setuQQ(String uQQ) {
        this.uQQ = uQQ;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuStauts() {
        return uStauts;
    }

    public void setuStauts(String uStauts) {
        this.uStauts = uStauts;
    }

    public void setuLoginTime(Date uLoginTime) {
        this.uLoginTime = uLoginTime;
    }

    public Date getuLoginTime() {
        return uLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uQQ='" + uQQ + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uStauts='" + uStauts + '\'' +
                ", uLoginTime=" + uLoginTime +
                '}';
    }
}
