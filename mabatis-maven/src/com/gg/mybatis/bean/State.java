package com.gg.mybatis.bean;

/**
 * @author 33863
 * @create 2022-01-23 15:47
 * @desc 测试Mybatis处理枚举类型
 **/
public enum State {
    Login(100, "用户登录"), Logout(200, "用户离线"), Remove(300, "用户不存在");
    //    Login,Logout,Remove;
    private Integer code;
    private String msg;

    private State(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static State getStateByCode(int code) {
        switch (code) {
            case 100:
                return Login;
            case 200:
                return Logout;
            case 300:
                return Remove;
            default:
                return null;
        }
    }

}
