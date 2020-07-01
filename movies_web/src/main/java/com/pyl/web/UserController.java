package com.pyl.web;

import com.pyl.pojo.MovieClass;
import com.pyl.pojo.User;
import com.pyl.pojo.Video;
import com.pyl.service.MovieClassService;
import com.pyl.service.MovieService;
import com.pyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 彭雨蕾
 * @Date Created in 2020/6/22
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieClassService MovieClassService;

    /**
     * @return java.lang.String
     * @Description 查询所有用户信息
     * @Param []
     **/
    @RequestMapping(value = "/findAll", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String findAll() {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Description 用户登录功能实现
     * @Param [user]
     **/
    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setuName(username);
        user.setuPwd(password);

        user = userService.login(user);

        if (user == null) {
            modelAndView.setViewName("regfail");
            return modelAndView;
        }
        List<Video> videoList = movieService.findAll();
        List<MovieClass> movieClassList = MovieClassService.findAll();


        modelAndView.addObject("users", user);
        modelAndView.addObject("classes", movieClassList);
        modelAndView.addObject("mlist", videoList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/registmain")
    public String registMain(){
        return "redirect:/regist.jsp";
    }
    @RequestMapping("/regist")
    public String register(User user){
        user.setuStauts("1");
        user.setuLoginTime(new Date());
        userService.register(user);
        return "redirect:/login.jsp";
    }

    /**
     * @return java.lang.String
     * @Description 修改用户密码
     * @Param [map, status]
     **/
    @RequestMapping("/uppassword")
    public String upPassword(ModelMap map, SessionStatus status,String uPwd) {
        User user = (User) map.get("users");
        user.setuPwd(uPwd);
        status.setComplete();

        userService.upPassword(user);

        return "redirect:/login.jsp";
    }

    @RequestMapping("/loginmain")
    public String loginMain() {
        return "redirect:/index.jsp";
    }

    /**
     * @return java.lang.String
     * @Description 用户退出登录功能实现
     * @Param [status]
     **/
    @RequestMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        List<Video> videoList = movieService.findAll();
        List<MovieClass> movieClassList = MovieClassService.findAll();

        modelAndView.addObject("classes", movieClassList);
        modelAndView.addObject("mlist", videoList);
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
