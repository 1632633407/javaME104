package com.pyl.service.impl;

import com.pyl.dao.MovieDao;
import com.pyl.pojo.Video;
import com.pyl.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Video> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Video getVideoByVid(String vid) {
        return movieDao.getVideoByVid(vid);
    }

    @Override
    public void updateVideo(Video video) {
        movieDao.updateVideo(video);
    }

    @Override
    public List<Video> findLimit() {
        return movieDao.findLimit();
    }

    @Override
    public void addMovie(Video video) {

    }

    @Override
    public void deleteMovie(String vId) {
        movieDao.deleteMovie(vId);
    }

    @Override
    public List<Video> findMoviesByClass(String classMId) {
        return movieDao.findMoviesByClass(classMId);
    }

    @Override
    public List<Video> findMovieByName(String keyword) {
        keyword = "%" + keyword + "%";
        System.out.println(keyword);
        return movieDao.findMovieByName(keyword);
    }
}
