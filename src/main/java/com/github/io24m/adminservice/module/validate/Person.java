package com.github.io24m.adminservice.module.validate;

import com.github.io24m.validate4java.validator.empty.Empty;
import lombok.Data;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 9:45
 */
@Data
public class Person {
    @Empty(configKey = "name", errorMessage = "姓名不能为空")
    private String name;

    @Empty(configKey = "age", errorMessage = "年龄不能为空")
    private String age;
}
