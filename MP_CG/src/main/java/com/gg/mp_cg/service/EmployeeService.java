package com.gg.mp_cg.service;

import com.gg.mp_cg.beans.Employee;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gg
 * @since 2022-02-01
 */
public interface EmployeeService extends IService<Employee> {
    void addEmployee(Employee employee);
    List<Employee> getPage(int begin, int size);
}
