package com.github.io24m.adminservice.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * validate_class
 * @author 
 */
@Data
public class ValidateClass implements Serializable {
    private String classType;

    private String className;

    private Boolean status;

    private String remark;

    private static final long serialVersionUID = 1L;
}