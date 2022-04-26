package com.gg.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 * @author 33863
 * @create 2022-01-24 9:40
 * @desc javaBean
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tbl_employee")
public class Employee  extends Model<Employee> {
//    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name",exist = true)
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
