package com.pyl.dao;

import com.pyl.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Repository
public interface MovieDao {
    List<Video> findAll();

    Video getVideoByVid(String vid);

    void updateVideo(Video video);

    List<Video> findLimit();

    void deleteMovie(String vId);

    List<Video> findMoviesByClass(String classMId);

    List<Video> findMovieByName(String keyword);
}
