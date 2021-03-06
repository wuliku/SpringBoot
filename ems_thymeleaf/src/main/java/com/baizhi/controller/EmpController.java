package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author:
 * @creat 2021-06-09-14:08
 * @description:
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "ems/emplist";
    }

    @PostMapping("/save")
    public String save(Emp emp) {
        empService.save(emp);
        System.out.println("保存成功");
        return "redirect:/emp/findAll";
    }

    @GetMapping("/delete")
    public String delete(String id) {
        empService.delete(id);
        return "redirect:/emp/findAll";
    }

    //根据id查询员工
    @GetMapping("/find")
    public String find(String id, Model model) {
        Emp emp = empService.find(id);
        model.addAttribute("emp", emp);
        return "/ems/updateEmp";
    }

    //更新员工信息
    @PostMapping("/update")
    public String update(Emp emp) {
        empService.update(emp);
        return "redirect:/emp/findAll";
    }
}
