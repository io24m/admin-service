package com.github.io24m.adminservice.common.utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * @author lk1
 * @description
 * @create 2020-11-19 15:31
 */
public class TestUtil {
    public String getMessage(LocalDate date) {
        String f = "";
        boolean test = true;
        //1.1 test
        //1.2 test
        if (test) {
            LocalDate now = LocalDate.now();
            //获取数据库的本月是否有1.1
            //存在 return
            //不存在，入库1.1 获取用户或者角色
        }
        return f;
    }


    public void task() {
        boolean test = true;
        //1.1 test
        //1.2 test
        if (test) {
            LocalDate now = LocalDate.now();
            //获取数据库的本月是否有1.1
            //存在 return
            //不存在，入库1.1 获取用户或者角色
        }
    }

    public class Message {
        private String id;
        private LocalDate date;
        private String userId;
        private String msg;
        private Boolean status;
    }
    @Getter
    @Setter
    public class PhoneNumber {
        private String countryCode;
        private String stateCode;
        private String number;
    }

    @MappedTypes(PhoneNumber.class)
    @MappedJdbcTypes(value = JdbcType.VARCHAR,includeNullJdbcType = false)
    public class MyBatisTypeHandler extends BaseTypeHandler<PhoneNumber> {


        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
//            EnumTypeHandler
            preparedStatement.setString(i,phoneNumber.getNumber());
        }

        @Override
        public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
            String string = resultSet.getString(s);
            PhoneNumber phoneNumber=new PhoneNumber();
            phoneNumber.setNumber(string);
            return phoneNumber;
        }

        @Override
        public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
            String string = resultSet.getString(i);
            PhoneNumber phoneNumber=new PhoneNumber();
            phoneNumber.setNumber(string);
            return phoneNumber;
        }

        @Override
        public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
            String string = callableStatement.getString(i);
            PhoneNumber phoneNumber=new PhoneNumber();
            phoneNumber.setNumber(string);
            return phoneNumber;
        }
    }
}
