package com.github.io24m.adminservice.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * validate_file_config
 * @author 
 */
@Data
public class ValidateFileConfig implements Serializable {
    private Integer id;

    private String classType;

    private String fileKey;

    private String validateType;

    private Boolean check;

    private Boolean pass;

    private String errorMessage;

    private static final long serialVersionUID = 1L;
}