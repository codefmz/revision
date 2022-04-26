package com.gg.mybatis.dao;

import com.gg.mybatis.bean.Dept;

/**
 * @author 33863
 * @create 2021-12-19 19:54
 * @desc dept 的 mapper 映射文件
 **/
public interface DeptMapper {

    Dept getDeptById(Integer id);

    Dept getDeptCollection(Integer id);

    Dept getDeptByIdStep(Integer id);


}
