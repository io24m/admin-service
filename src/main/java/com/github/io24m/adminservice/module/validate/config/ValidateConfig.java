package com.github.io24m.adminservice.module.validate.config;

import java.io.Serializable;
import lombok.Data;

/**
 * validate_config
 * @author 
 */
@Data
public class ValidateConfig implements Serializable {
    private Integer id;

    private String className;

    private String key;

    private String validateType;

    private Boolean check;

    private Boolean pass;

    private String errormessage;

    private static final long serialVersionUID = 1L;
}