package com.pyl.service;

import com.pyl.pojo.MovieClass;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
public interface MovieClassService {
    List<MovieClass> findAll();

    void deleteClass(String mId);

    void insertClass(String mName);
}
