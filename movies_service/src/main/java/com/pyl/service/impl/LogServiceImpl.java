package com.pyl.service.impl;

import com.pyl.dao.LogDao;
import com.pyl.pojo.Log;
import com.pyl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/27
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }
}
