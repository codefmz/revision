package com.gg.mp_cg;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author 33863
 * @create 2022-02-03 11:36
 * @desc 使用自动填充
 **/
public class MyMetaObjectHandle extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object lastName = getFieldValByName("lastName", metaObject);
        if(lastName == null){
            System.out.println("====满足填充要求====");
            setFieldValByName("lastName","无名",metaObject);
        }
    }
    @Override
    public void updateFill(MetaObject metaObject) {
    }
}
