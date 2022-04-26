package com.gg.mybatis.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author 33863
 * @create 2021-12-19 18:50
 * @desc Employee 的部门
 **/
public class Dept implements Serializable {
    private Integer deptNO;
    private String deptName;
    private List<Employee> list;

    public Dept(Integer deptNO, String deptName) {
        this.deptNO = deptNO;
        this.deptName = deptName;
    }

    public Dept() {
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public Integer getDeptNO() {
        return deptNO;
    }

    public void setDeptNO(Integer deptNO) {
        this.deptNO = deptNO;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNO='" + deptNO + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
