package com.github.io24m.adminservice.service.sys;

import com.github.io24m.adminservice.domain.SysUser;
import com.github.io24m.adminservice.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-12-10 14:29
 */
@Service
public class UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> getUser() {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        return sysUsers;
    }
}
