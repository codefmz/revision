package com.gg.mp_cg.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.gg.mp_cg.beans.Employee;
import com.gg.mp_cg.mapper.EmployeeMapper;
import com.gg.mp_cg.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gg
 * @since 2022-02-01
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public void addEmployee(Employee employee) {
        baseMapper.insert(employee);
    }
    @Override
    public List<Employee> getPage(int begin, int size) {
        return baseMapper.selectPage(new Page<Employee>(begin,size),null);
    }

}
