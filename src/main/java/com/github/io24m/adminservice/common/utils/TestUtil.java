package com.github.io24m.adminservice.common.utils;

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
}
