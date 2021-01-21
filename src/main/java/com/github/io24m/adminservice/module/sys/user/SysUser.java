package com.github.io24m.adminservice.module.sys.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * lk1
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private Boolean enable;

    private Boolean sysUser;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}