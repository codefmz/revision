package com.gg.mp_cg.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.gg.mp_cg.beans.Employee;
import com.gg.mp_cg.service.EmployeeService;
import com.gg.mp_cg.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gg
 * @since 2022-02-01
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    public static void main(String[] args) {

    }

    public void add(Employee employee){
        employeeService.addEmployee(employee);
    }

    public List<Employee> page(int begin, int size){
        return employeeService.getPage(begin, size);
    }
}

