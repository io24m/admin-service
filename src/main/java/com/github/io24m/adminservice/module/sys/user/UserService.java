package com.github.io24m.adminservice.module.sys.user;

import com.github.io24m.adminservice.domain.SysUser;
import com.github.io24m.adminservice.mapper.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
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
        return sysUserMapper.selectAll();
    }

    public SysUser getUser(Integer id) {
        if (id == null) {
            return null;
        }
        return sysUserMapper.selectByPrimaryKey(id);
    }

    public SysUser getUser(String account, String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return null;
        }
        return sysUserMapper.selectByAccountAndPassword(account, password);
    }

    public SysUser getUser(String account) {
        if (StringUtils.isBlank(account)) {
            return null;
        }
        return sysUserMapper.selectByAccount(account);
    }

}
