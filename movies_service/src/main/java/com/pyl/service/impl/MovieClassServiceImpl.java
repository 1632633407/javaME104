package com.pyl.service.impl;

import com.pyl.dao.MovieClassDao;
import com.pyl.pojo.MovieClass;
import com.pyl.service.MovieClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Service("movieClassService")
public class MovieClassServiceImpl implements MovieClassService {
    @Autowired
    private MovieClassDao movieClassDao;
    @Override
    public List<MovieClass> findAll() {
        return movieClassDao.findAll();
    }

    @Override
    public void deleteClass(String mId) {
        movieClassDao.deleteClass(mId);
    }

    @Override
    public void insertClass(String mName) {
        MovieClass movieClass = new MovieClass();
        movieClass.setmName(mName);
        movieClass.setmId(UUID.randomUUID().toString());
        movieClassDao.insertClass(movieClass);
    }
}
