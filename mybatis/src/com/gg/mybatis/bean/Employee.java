package com.gg.mybatis.bean;

/**
 * @author 33863
 * @create 2021-12-16 16:55
 * @desc employee 测试类
 **/
public class Employee {
    private Integer id;
    private String last_name;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String last_name, String gender, String email) {
        this.id = id;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
