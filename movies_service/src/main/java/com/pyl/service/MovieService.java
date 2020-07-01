package com.pyl.service;

import com.pyl.pojo.Video;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
public interface MovieService {
    List<Video> findAll();

    Video getVideoByVid(String vid);

    void updateVideo(Video video);

    List<Video> findLimit();

    void addMovie(Video video);

    void deleteMovie(String vId);

    List<Video> findMoviesByClass(String classMId);

    List<Video> findMovieByName(String keyword);
}
