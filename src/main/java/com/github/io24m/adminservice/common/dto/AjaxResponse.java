package com.github.io24m.adminservice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lk1
 * @description
 * @create 2020-11-18 9:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResponse<T> {
    private int code = 1;
    private T result;
    private int count;
    private boolean success = true;
    private String message;

    public static AjaxResponse error(String message) {
        AjaxResponse<Object> err = new AjaxResponse<>();
        err.setMessage(message);
        err.setSuccess(false);
        return err;
    }

    public static AjaxResponse success() {
        return success(null);
    }

    public static AjaxResponse success(String message) {
        AjaxResponse<Object> err = new AjaxResponse<>();
        err.setMessage(message);
        err.setSuccess(true);
        return err;
    }

    public static <T> AjaxResponse<T> result(T result) {
        AjaxResponse<T> res = new AjaxResponse<>();
        res.setResult(result);
        res.setSuccess(true);
        return res;
    }
}
