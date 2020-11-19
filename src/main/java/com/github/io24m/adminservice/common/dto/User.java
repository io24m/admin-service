package com.github.io24m.adminservice.common.dto;

import lombok.Data;

/**
 * @author lk1
 * @description
 * @create 2020-11-19 14:27
 */
@Data
public class User {
    private String userId;
    private String userName;
    private String account;
    private String password;
}
