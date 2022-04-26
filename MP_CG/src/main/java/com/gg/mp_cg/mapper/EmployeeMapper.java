package com.gg.mp_cg.mapper;

import com.gg.mp_cg.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gg
 * @since 2022-02-01
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
       void delete();
}
