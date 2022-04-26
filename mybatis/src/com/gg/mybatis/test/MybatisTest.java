package com.gg.mybatis.test;

import com.gg.mybatis.bean.Employee;
import com.gg.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author 33863
 * @create 2021-12-16 17:24
 * @desc 测试类
 **/
public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "config/mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//        List<Employee> allEmps = mapper.getAllEmps();
//        allEmps.forEach(System.out::println);


//        Employee employee = new Employee(null, "王子辛",
//                "女", "wzx@qq.com");
//        Boolean aBoolean = mapper.addEmp(employee);
//        System.out.println("aBoolean = " + aBoolean);
//        Integer id = employee.getId();
//        System.out.println("id = " + id);

        //添加操作必须要执行提交事务操作
//        sqlSession.commit();

//        Employee empById = mapper.getEmpById(7);
//        System.out.println(empById);
//
//        Employee employee = mapper.getEmpByIdAndName(22, "王子辛");
//        System.out.println("employee = " + employee);

//        Map<String,Object> map = new HashMap<>();
//        map.put("id", 22);
//        map.put("name", "王子辛");
//        Employee empByMap = mapper.getEmpByMap(map);
//        System.out.println("empByMap = " + empByMap);

//        Employee empById = mapper.getEmpById(new Employee(7, null, null, null));
//        System.out.println("empById = " + empById);



//        Map<String, Object> mapOfEmp = mapper.getMapOfEmp(1);
//        for (Map.Entry<String, Object> entry : mapOfEmp.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

        List<Employee> allEmps = mapper.getAllEmps();
        for (Employee allEmp : allEmps) {
            System.out.println("allEmp = " + allEmp);
        }
        sqlSession.close();
    }
 }
