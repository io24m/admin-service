package com.github.io24m.adminservice.common.dto;

import lombok.*;

import java.util.Collection;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-19 13:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AjaxPageResponse<T> extends AjaxResponse<Collection<T>> {
    private int count;
    public static <T> AjaxPageResponse<T> result(Collection<T> result) {
        AjaxPageResponse<T> res = new AjaxPageResponse<>();
        res.setResult(result);
        res.setSuccess(true);
        return res;
    }
}
