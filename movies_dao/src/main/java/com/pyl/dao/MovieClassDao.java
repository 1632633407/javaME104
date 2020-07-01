package com.pyl.dao;

import com.pyl.pojo.MovieClass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Repository
public interface MovieClassDao {

    List<MovieClass> findAll();

    void deleteClass(String mId);


    void insertClass(MovieClass movieClass);
}
