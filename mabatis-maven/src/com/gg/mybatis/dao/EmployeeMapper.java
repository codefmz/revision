package com.gg.mybatis.dao;


import com.gg.mybatis.bean.Dept;
import com.gg.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface EmployeeMapper {
    List<Employee> getEmpByDeptId(Integer deptId);
    List<Employee> getAllEmps();
    Boolean addEmp(Employee employee);
    /**
     * 多参数查询
     */
    Employee getEmpByIdAndName(@Param("id2") Integer id, @Param("name2") String name);
    Employee getEmpById(Integer id);
    Employee getEmpByMap(Map<String, Object> map);
    Map<String,Object> getMapOfEmp(Integer id);
    Employee getEmpByStep(Integer id);

    List<Employee> getEmpWithDc();
    Long insert(Employee employee);

}
