package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:
 * @creat 2021-06-09-10:39
 * @description:
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndex() {
        return "ems/login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "ems/regist";
    }

    @GetMapping("/toSave")
    public String toSave() {
        return "ems/addEmp";
    }

    @RequestMapping("/update")
    public String toUpdate() {
        return "ems/updateEmp";
    }
}
