package com.gg.mybatis.test;


import com.gg.mybatis.bean.Dept;
import com.gg.mybatis.bean.Employee;
import com.gg.mybatis.bean.State;
import com.gg.mybatis.dao.DeptMapper;
import com.gg.mybatis.dao.EmployeeMapper;
import com.gg.mybatis.dao.EmployeeMapperDynamicSql;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import javax.xml.transform.Source;
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

        List<Employee> allEmps = mapper.getAllEmps();
        allEmps.forEach(System.out::println);


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
//        System.out.println(empById.getDept());
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


        //测试分步查询
//        DeptMapper mapper1 = sqlSession.getMapper(DeptMapper.class);
//        Dept deptById = mapper1.getDeptById(1);
//        System.out.println(deptById);
//        Employee employee = mapper.getEmpByStep(2);
//        System.out.println(employee.getEmail());
//        System.out.println(employee.getDept());

//        Dept dept = mapper1.getDeptCollection(1);
//        System.out.println("dept = " + dept);
//        for (Employee employee : dept.getList()) {
//            System.out.println("employee = " + employee);
//        }
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        DeptMapper mapper1 = sqlSession.getMapper(DeptMapper.class);
//        //测试collection 的分步查询
//        Dept deptByIdStep = mapper1.getDeptByIdStep(1);
//        System.out.println(deptByIdStep);
//        List<Employee> list = deptByIdStep.getList();
//        for (Employee employee : list) {
//            System.out.println("employee = " + employee);
//        }
//        List<Employee> empByDeptId = mapper.getEmpByDeptId(1);
//        for (Employee employee : empByDeptId) {
//            System.out.println("employee = " + employee);
//        }

        List<Employee> empWithDc = mapper.getEmpWithDc();
        for (Employee employee : empWithDc) {
            System.out.println("employee = " + employee);
        }
        sqlSession.close();
    }

    /**
     * 测试动态sql
     */
    @Test
    public void test3(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapperDynamicSql mapper = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
        //测试if, trim choose
//        List<Employee> empByIf = mapper.getEmpByIf(new Employee(1,"杨不悔","0",null));
//        List<Employee> empByIf = mapper.getEmpByIf(null);
//        for (Employee employee : empByIf) {
//            System.out.println("employee = " + employee);
//        }
//
//        System.out.println("==============");
//
//        Long aLong = mapper.updateEmp(new Employee(1, "杨不悔", "0", null));
//        System.out.println("杨不悔 = " + aLong);
//
//        System.out.println("==============");

//        Integer[] ints = {1,2, 3, 4, 5, 6, 7, 8};
//        List<Employee> empForeach = mapper.getEmpForeach(Arrays.asList(ints));
//        for (Employee foreach : empForeach) {
//            System.out.println("foreach = " + foreach);
//        }

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(null,"周节轮", "1", "zjl@qq.com"));
        employees.add(new Employee(null,"流得滑", "1", "ldh@qq.com"));
        employees.add(new Employee(null,"章血有", "1", "zxy@qq.com"));
        Long aLong = mapper.saveBatch(employees);
        System.out.println("aLong = " + aLong);

//        List<Employee> employees = mapper.testBind("杨");
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

    }

    //测试缓存
    @Test
    public void test4(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);

        Employee empById = mapper.getEmpById(1);
        System.out.println("empById = " + empById);

        sqlSession.close();

        Employee empById2 = mapper2.getEmpById(1);
        System.out.println("empById2 = " + empById2);
//        sqlSession.clearCache();
    }

    /**
     * 测试使用pageHelper分页查询
     */
    @Test
    public void test5(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();


        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1,4);
        List<Employee> allEmps = mapper.getAllEmps();
        for (Employee allEmp : allEmps) {
            System.out.println("allEmp = " + allEmp);
        }
    }


    /**
     * 测试批量操作
     */
    @Test
    public void test6(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //批量执行的Executor
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            mapper.insert(new Employee(null, UUID.randomUUID().toString().substring(0,5),Math.random() >=0.5?"1":"0",UUID.randomUUID().toString().substring(0,5)));
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试处理枚举类型
     */
    @Test
    public void test7(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //批量执行的Executor
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee employee = new Employee(null, "王子", "0", "wz@qq.com", null, State.Logout);
//        mapper.insert(employee);

        Employee employee = mapper.getEmpById(3039);
        System.out.println(employee.getState());
        System.out.println(employee.getId());
        sqlSession.commit();
        sqlSession.close();
    }


}
