package com.gg.mybatis.handle;

import com.gg.mybatis.bean.State;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 33863
 * @create 2022-01-23 17:49
 * @desc 自定义处理枚举类型 State的类型
 **/
public class EnumHandle implements TypeHandler<State> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, State state, JdbcType jdbcType) throws SQLException {
        // 将sql中的第i个参数设置为state的code
        preparedStatement.setString(i,state.getCode().toString());
    }

    @Override
    public State getResult(ResultSet resultSet, String s) throws SQLException {
        //s 为从数据库中查询得到的数据，为枚举的状态码
        //将状态码转变成为整数
        int anInt = resultSet.getInt(s);
        //通过状态码获取枚举对象
        State stateByCode = State.getStateByCode(anInt);
        return stateByCode;
    }

    @Override
    public State getResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        //通过状态码获取枚举对象
        State stateByCode = State.getStateByCode(anInt);
        return stateByCode;
    }

    @Override
    public State getResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        //通过状态码获取枚举对象
        State stateByCode = State.getStateByCode(anInt);
        return stateByCode;
    }
}
