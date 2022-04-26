package com.gg.mp_cg.sqlInjector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author 33863
 * @create 2022-02-02 21:42
 * @desc 测试全局自动配置
 **/
public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant,
                       Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        String sql = "delete * from " + table.getTableName();
        String method = "delete";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
