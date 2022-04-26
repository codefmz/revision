package com.gg.mybatis.dao;

import com.gg.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeMapper {
    List<Employee> getAllEmps();
    Boolean addEmp(Employee employee);
    /**
     * 多参数查询
     */
//    Employee getEmpByIdAndName(@Param("id2") Integer id, @Param("name2") String name);
    Employee getEmpByIdAndName( Integer id, String name);
    Employee getEmpById(@Param("e") Employee e);
    Employee getEmpByMap(Map<String, Object> map);


    Map<String,Object> getMapOfEmp(Integer id);
}
