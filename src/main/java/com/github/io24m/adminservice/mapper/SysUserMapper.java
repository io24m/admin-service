package com.github.io24m.adminservice.mapper;

import com.github.io24m.adminservice.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    SysUser selectByAccount(@Param("account") String account);

    List<SysUser> selectAll();

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}