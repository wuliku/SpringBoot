package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author:
 * @creat 2021-06-09-10:57
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册方法
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session) {
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equalsIgnoreCase(code)) {
            userService.register(user);
            return "redirect:/index"; //重定向到index页面，跳转到login页面
        } else {
            return "redirect:/toRegister";//重定向到注册页面
        }
    }

    //登录方法
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User login = userService.login(username, password);
        if (login != null) {
            session.setAttribute("user", login);
            return "redirect:/emp/findAll";//登录到员工表中
        } else {
            return "redirect:/index"; //跳转回到登录的控制器中
        }
    }

    //生成验证码
    @RequestMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将验证码放入到图形中
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //将验证码以键值对的形式存入到session域中
        session.setAttribute("code", securityCode);

        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
}
