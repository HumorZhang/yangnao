package com.zgg.controller;


import com.zgg.bean.Department;
import com.zgg.bean.Employee;
import com.zgg.mapper.DepartmentMapper;
import com.zgg.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * zgg
 * 2018/10/30 14:18
 */
@Controller
public class EmployeeController {
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
//    }

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;


    /*
    进入员工管理页面，查看所有员工
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<com.zgg.bean.Employee> empAll = employeeMapper.getEmpAll();
        model.addAttribute("emps", empAll);

        return "emp/list";

    }

    /*
    进入员工添加页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        return "emp/add";
    }

    @PostMapping(value = "/emp")
    /*
    添加员工
     */
    public String addEmp(Employee employee){
        employeeMapper.insertEmp(employee);

       System.out.println(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee= employeeMapper.getEmpById(id);

        model.addAttribute("emp", employee);

        return "emp/add";


    }
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);

//        System.out.println(employee);
        return "redirect:/emps";

    }

    @DeleteMapping("/emp/{id}")

    public String deletEmp(@PathVariable("id") Integer id){
        employeeMapper.deleteEmpById(id);
        return "redirect:/emps";
    }

}
