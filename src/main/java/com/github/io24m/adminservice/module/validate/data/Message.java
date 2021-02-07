package com.github.io24m.adminservice.module.validate.data;

import lombok.Data;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 13:28
 */
@Data
public class Message {
    private boolean success;
    private List<String> message;
    private List<String> errorMessage;
}
