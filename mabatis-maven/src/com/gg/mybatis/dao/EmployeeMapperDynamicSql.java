package com.gg.mybatis.dao;

import com.gg.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSql {

        List<Employee> getEmpByIf(Employee employee);

        Long updateEmp(Employee employee);

        List<Employee> getEmpForeach(@Param("ids") List<Integer> ids);

        Long saveBatch(@Param("emps") List<Employee> emps);

        List<Employee> testBind(@Param("lastName") String lastName);

}
