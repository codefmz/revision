package com.gg.mp_cg;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.plugins.Page;
import com.gg.mp_cg.beans.Employee;
import com.gg.mp_cg.controller.EmployeeController;
import com.gg.mp_cg.mapper.EmployeeMapper;
import com.gg.mp_cg.service.EmployeeService;
import com.gg.mp_cg.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 33863
 * @create 2022-02-01 18:59
 * @desc 测试mybatisPlus的代码生成器
 **/
public class TestMp {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
    public static void main(String[] args) {
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //它在执行结束后返回的还是当前的 globalConfig 对象
        globalConfig.setActiveRecord(true) //是否支持AR模式
                .setAuthor("gg") //设置作者
                .setOutputDir("F:\\Code\\revision\\MP_CG\\src\\main\\java")//文件位置
                .setFileOverride(true) //文件覆盖
                .setIdType(IdType.AUTO) //主键策略
                .setServiceName("%sService") //设置生成的service接口的名字的首字母不带I
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp?characterEncoding=utf-8&allowMultiQueries=true")
                .setUsername("root")
                .setPassword("fmw");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)//全局大小写命名
                .setDbColumnUnderline(true) //指定表名字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("tbl_")
                .setInclude("tbl_employee"); //使用的表
        //4.包名配置
        PackageConfig paConfig = new PackageConfig();
        paConfig.setParent("com.gg.mp_cg")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(stConfig)
                .setPackageInfo(paConfig);
        autoGenerator.execute();
    }

    //测试执行性能分析器
    @Test
    public void test(){
        EmployeeController bean = ioc.getBean(EmployeeController.class);
        Employee employee = new Employee();
        employee.setLastName("徐凡");
        employee.setEmail("xf@qq.com");
        employee.setAge(34);
        employee.setGender("1");
        bean.add(employee);
    }
    @Test
    public void test2(){
//        EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);
//        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 4), null);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
        EmployeeController bean = ioc.getBean(EmployeeController.class);
        List<Employee> page = bean.page(1, 4);
        for (Employee employee : page) {
            System.out.println("employee = " + employee);
        }
    }
    //测试分页插件
    @Test
    public void test3(){
        Page<Employee> page = new Page<Employee>(1, 4);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        System.out.println("单前页码：" + page.getCurrent());
        System.out.println("总页码数：" + page.getPages());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
        //可以直接将 employees设置成为 page的属性，直接将page对象返回个前端，page对象包含了所需要的全部信息
        page.setRecords(employees);

    }

    @Test
    public void test4(){
        Integer delete = employeeMapper.delete(null);
    }
    //测试乐观锁
    @Test
    public void test5(){
        Employee employee = new Employee();
        employee.setId(16);
        employee.setLastName("徐月二");
        employee.setEmail("xf@qq.com");
        employee.setAge(34);
        employee.setGender("1");
//        employee.setVersion(1);
        employeeMapper.updateById(employee);
    }

    @Test
    public void test6(){
        //测试自定义的全局删除操作
//        employeeMapper.delete();
        //测试逻辑删除
//        employeeMapper.deleteById(3);
        Employee employee = new Employee();
        employee.setGender("1");
        employee.setEmail("haha@qq.com");
        employee.setAge(44);
        employee.setVersion(1);
        employeeMapper.insert(employee);
    }

}
