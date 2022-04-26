package com.gg.mp_cg.beans;

import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gg
 * @since 2022-02-01
 */
@TableName("tbl_employee")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(fill = FieldFill.INSERT)
    private String lastName;
    private String email;
    private String gender;
    private Integer age;
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Version
    private Integer version;

    public Integer getLogicDeleteValue() {
        return logicDeleteValue;
    }

    public void setLogicDeleteValue(Integer logicDeleteValue) {
        this.logicDeleteValue = logicDeleteValue;
    }

    @TableLogic(value = "1",delval = "-11")
    private Integer logicDeleteValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
        ", id=" + id +
        ", lastName=" + lastName +
        ", email=" + email +
        ", gender=" + gender +
        ", age=" + age +
        "}";
    }
}
