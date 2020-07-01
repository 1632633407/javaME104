package com.pyl.dao;

import com.pyl.pojo.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/27
 */
@Repository
public interface LogDao {
    List<Log> findAll();
}
