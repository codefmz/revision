package com.gg.mybatis.plug;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.lang.annotation.Annotation;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 33863
 * @create 2022-01-23 10:00
 * @desc 创建Mybatis的插件
 **/
@Intercepts(
        @Signature(type = StatementHandler.class, method = "parameterize", args = Statement.class)
)
public class MyFirstPlug implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Plug  == " + this.getClass().getName() + " method = " + invocation.getMethod());
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("将要包装的对象：" + target);
        Object wrappedTarget = Plugin.wrap(target, this);
        return wrappedTarget;
    }

    @Override
    public void setProperties(Properties properties) {
        //将插件注册时的属性设置进来
        System.out.println("插件的属性：" + properties);
    }
}
