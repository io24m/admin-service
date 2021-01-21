package com.github.io24m.adminservice.module.sys.role;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_role
 * @author 
 */
@Data
public class SysRole implements Serializable {
    private Integer id;

    private String roleName;

    private Boolean enable;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}