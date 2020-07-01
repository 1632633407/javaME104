package com.pyl.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pyl.pojo.Log;
import com.pyl.pojo.MovieClass;
import com.pyl.pojo.User;
import com.pyl.pojo.Video;
import com.pyl.service.LogService;
import com.pyl.service.MovieClassService;
import com.pyl.service.MovieService;
import com.pyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/23
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MovieClassService movieClassService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @RequestMapping("/loginmain")
    public String loginMain() {
        return "admin/login";
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 管理员登录
     * @Param [uName, uPwd]
     **/
    @RequestMapping("/login")
    public ModelAndView login(String uName, String uPwd) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setuName(uName);
        user.setuPwd(uPwd);

        user = userService.login(user);

        if (user == null) {
            modelAndView.setViewName("regfail");
            return modelAndView;
        }

        modelAndView.addObject("users", user);
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 用户信息查询展示
     * @Param []
     **/
    @RequestMapping("/userManager")
    public ModelAndView userManager() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.findAll();

        modelAndView.addObject("users", userList);
        modelAndView.setViewName("admin/user-table");
        return modelAndView;
    }

    /**
     * @return java.lang.String
     * @Description 修改用户权限
     * @Param [uName, uStauts]
     **/
    @RequestMapping("trVip")
    public String trVip(String uName, String uStauts) {
        User user = new User();
        user.setuName(uName);
        user.setuStauts(uStauts);
        userService.updateUserStatus(user);

        return "redirect:userManager";
    }

    @RequestMapping("delUser")
    public String delUser(String uName) {
        userService.deleteUserByUName(uName);
        return "redirect:userManager";
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 查询所有电影信息
     * @Param []
     **/
    @RequestMapping("movieManager")
    public ModelAndView movieManager() {
        ModelAndView modelAndView = new ModelAndView();
        List<Video> videoList = movieService.findAll();

        modelAndView.addObject("movies", videoList);
        modelAndView.setViewName("admin/movie-table");
        return modelAndView;
    }

    /**
     * @return java.lang.String
     * @Description 删除电影
     * @Param [vId]
     **/
    @RequestMapping("delMovie")
    public String deleteMovie(String vId) {
        movieService.deleteMovie(vId);
        return "redirect:movieManager";
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 查询所有电影分类
     * @Param []
     **/
    @RequestMapping("classManager")
    public ModelAndView classManager() {
        ModelAndView modelAndView = new ModelAndView();
        List<MovieClass> classList = movieClassService.findAll();

        modelAndView.addObject("classes", classList);
        modelAndView.setViewName("admin/class-table");
        return modelAndView;
    }

    /**
     * @return java.lang.String
     * @Description 删除电影分类
     * @Param [mId]
     **/
    @RequestMapping("delClass")
    public String deleteClass(String mId) {
        movieClassService.deleteClass(mId);
        return "redirect:classManager";
    }

    @RequestMapping("insClassMain")
    public String insClassMain() {
        return "admin/addClass";
    }

    /**
     * @return java.lang.String
     * @Description 插入电影分类
     * @Param [mName]
     **/
    @RequestMapping("insertClass")
    public String insertClass(String mName) {
        movieClassService.insertClass(mName);
        return "redirect:classManager";
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 分页查询所有日志信息
     * @Param []
     **/
    @RequestMapping("/allLog")
    public ModelAndView findAllLog() {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(1, 10);
        List<Log> logList = logService.findAll();
        PageInfo<Log> logPageInfo = new PageInfo<>(logList);

        modelAndView.addObject("pageInfo", logPageInfo);
        modelAndView.setViewName("admin/loginfo");
        return modelAndView;
    }

    @RequestMapping("/pageLog")
    public ModelAndView pageLog(String pageNum){
        ModelAndView modelAndView = new ModelAndView();
        int parseInt = Integer.parseInt(pageNum);
        PageHelper.startPage(parseInt, 10);
        List<Log> logList = logService.findAll();
        PageInfo<Log> logPageInfo = new PageInfo<>(logList);

        modelAndView.addObject("pageInfo", logPageInfo);
        modelAndView.setViewName("admin/loginfo");
        return modelAndView;
    }
    /**
     * 上传电影信息
     *
     * @return
     */
    @RequestMapping("/upload")
    public ModelAndView addMovieMain() {
        ModelAndView mv = new ModelAndView();
        List<MovieClass> classList = movieClassService.findAll();
        mv.addObject("mclasses", classList);
        mv.setViewName("/admin/upload");
        return mv;
    }

    /**
     * 保存电影
     *
     * @param movie
     * @param picture
     * @param vName
     * @param vInfo
     * @param mName
     * @return
     */
    @RequestMapping("/filesUpload")
    public ModelAndView addMovie(MultipartFile movie, MultipartFile picture, String vName, String vInfo, String mName, String isVip) {
        ModelAndView mv = new ModelAndView();
        Video video = new Video();
        video.setvName(vName);
        //给电影唯一的ID值
        video.setvId(UUID.randomUUID().toString());
        video.setvInfo(vInfo);
        video.setmName(mName);
        video.setvUrl("/video/" + movie.getOriginalFilename());
        video.setvImg("/img/" + picture.getOriginalFilename());
        video.setvCount(0);
        video.setIsVip(isVip);
        //获取全类路径
        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        //视频目录
        String videoRoot = classpath.replaceAll("WEB-INF/classes/", "") + "video/";
        //封面目录
        String imageRoot = classpath.replaceAll("WEB-INF/classes/", "") + "img/";
        //保存文件
        boolean b = saveFile(movie, videoRoot);
        boolean a = saveFile(picture, imageRoot);
        if (a && b) {
            movieService.addMovie(video);
        }
        List<Video> videoList = movieService.findAll();
        mv.addObject("movies", videoList);
        mv.setViewName("/admin/movie-table");
        return mv;
    }

    /**
     * @return boolean
     * @Description 保存文件
     * @Param [file, path]
     **/
    private boolean saveFile(MultipartFile file, String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists()) {
                    filepath.mkdirs();
                }
                // 文件保存路径
                String savePath = path + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
