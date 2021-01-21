package com.github.io24m.adminservice.module.sys.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-12-14 10:26
 */
@Service
public class RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<SysRole> getRole() {
        return sysRoleMapper.selectAll();
    }

    public void deleteRole(Integer id) {
        sysRoleMapper.deleteByPrimaryKey(id);
    }
}
