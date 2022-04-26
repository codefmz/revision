package com.gg.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gg.bean.Employee;
import com.gg.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 33863
 * @create 2022-01-24 10:21
 * @desc 测试MybatisPlus
 **/
public class TestMp {
    //获取ioc容器
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() throws Exception{
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println("dataSource = " + dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = new Employee(null, "王子蛋", "wzx@qq.com", 1, 22);
        Integer affectLine = employeeMapper.insert(employee);
        System.out.println(affectLine);
        System.out.println("自增主键的id值是: " + employee.getId());

    }

    //测试修改操作
    @Test
    public void test2(){
        EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(5);
        employee.setEmail("55@qq.com");
        employee.setGender(1);
//        employee.setAge(55);
        employee.setLastName("王大锤");
        employeeMapper.insert(employee);//会根据employee的属性值是否为 null 设置sql
        //UPDATE tbl_employee SET last_name=?, email=?, age=? WHERE Id=?
        //所以 employee 属性值为null不会修改数据库中的值
        Integer integer = employeeMapper.updateAllColumnById(employee);
        //默认sql修改全列的值，属性为null， 会将数据库中的同列下的值设置为null
        System.out.println("影响条数：" + integer);
    }

    //测试查询操作
    @Test
    public void test3(){
        EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
//        Employee employee = employeeMapper.selectById(7);
//        System.out.println("employee = " + employee);
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        List<Employee> employees = employeeMapper.selectBatchIds(list);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

//        Map<String, Object> map = new HashMap<>();
//        map.put("last_name","王子新");
//        map.put("gender",1);
//        List<Employee> employees = employeeMapper.selectByMap(map);

        //分页操作
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 4), null);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    //使用条件构造器，
    @Test
    public void test4(){
        EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
        //查询年龄在：18~50 的男性
        List<Employee> age = employeeMapper.selectPage(new Page<Employee>(1, 20),
                new EntityWrapper<Employee>().between(false,"age", 18, 50)
                        .eq("gender",0));
        //查询名字中含有王字的人
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .like("last_name", "王"));
        //修改名字中带 王字的， 为null，sql添加字段
        Map<String, Object> map = new HashMap<>();
        map.put("id",8);
//        map.put("last_name","王子蛋");
        employeeMapper.update(new Employee(null,"徐缺","xq@qq.com",null,44),
                new EntityWrapper<Employee>().allEq(map));

    }

    //测试使用 AR 模式
    @Test
    public void test5(){
        Employee employee = new Employee(null, "方形", "fx@qq.com", 1, 40);
        boolean insert = employee.insert();
        System.out.println("insert = " + insert);
    }
}
