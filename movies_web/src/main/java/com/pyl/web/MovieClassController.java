package com.pyl.web;

import com.pyl.pojo.MovieClass;
import com.pyl.pojo.Video;
import com.pyl.service.MovieClassService;
import com.pyl.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Controller
@RequestMapping("/movieClass")
public class MovieClassController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieClassService movieClassService;
    @RequestMapping("/clist")
    public ModelAndView findMoviesByClass(String classMId){
        ModelAndView modelAndView = new ModelAndView();

        List<MovieClass> movieClassList = movieClassService.findAll();
        List<Video> videoList=movieService.findMoviesByClass(classMId);

        modelAndView.addObject("classes", movieClassList);
        modelAndView.addObject("mlist", videoList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
