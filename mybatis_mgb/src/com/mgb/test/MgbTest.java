package com.mgb.test;

import com.mgb.bean.Employee;
import com.mgb.bean.EmployeeExample;
import com.mgb.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 33863
 * @create 2021-12-28 9:49
 * @desc 测试
 **/
public class MgbTest {

    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "config/mybatis.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
       使逆向工程开始工作，
       这个执行之后会生成自动创建的bean和mapper，以及mapper的xml配置
     */
    @Test
    public void test1() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("resources/mgb.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void test2() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//        List<Employee> employees = mapper.selectByExample(null);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }


//        Employee employee1 = new Employee();
//        employee1.setGender("0");
//        employee1.setLastName("maria");
//        employee1.setEmail("maria@qq.com");
//        mapper.insert(employee1);
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andGenderEqualTo("1");
        EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
        criteria1.andIdBetween(1, 100);
        employeeExample.or(criteria1);
        List<Employee> employees = mapper.selectByExample(employeeExample);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
