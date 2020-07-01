package com.pyl.web;

import com.pyl.pojo.MovieClass;
import com.pyl.pojo.Video;
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
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private com.pyl.service.MovieClassService MovieClassService;

    @RequestMapping("/info")
    public ModelAndView movieInfo(String vid, String cut) {
        ModelAndView modelAndView = new ModelAndView();
        List<MovieClass> classList = MovieClassService.findAll();
        Integer vCount = Integer.parseInt(cut) + 1;
        Video video = new Video();
        video.setvCount(vCount);
        video.setvId(vid);
        movieService.updateVideo(video);
        Video newVideo = movieService.getVideoByVid(vid);


        modelAndView.addObject("classes", classList);
        modelAndView.addObject("movie",newVideo);
        modelAndView.setViewName("single");

        return modelAndView;
    }

    @RequestMapping("/mvlistF")
    public ModelAndView mvListF(){
        ModelAndView modelAndView = new ModelAndView();

        List<MovieClass> classList = MovieClassService.findAll();
        List<Video> videoList=movieService.findLimit();

        modelAndView.addObject("classes",classList);
        modelAndView.addObject("mlist",videoList);
        modelAndView.setViewName("list");
        return modelAndView;
    }
    @RequestMapping("/mvlist")
    public String mvlist(){
        return "redirect:/user/index";
    }
    @RequestMapping("findOne")
    public ModelAndView findMovieByName(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        List<Video> videoList=movieService.findMovieByName(keyword);
        List<MovieClass> classList = MovieClassService.findAll();


        modelAndView.addObject("classes",classList);
        modelAndView.addObject("mlist",videoList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
