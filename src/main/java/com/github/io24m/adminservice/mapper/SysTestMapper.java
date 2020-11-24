package com.github.io24m.adminservice.mapper;

import com.github.io24m.adminservice.domain.SysTest;

import java.io.Serializable;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 10:47
 */
public interface SysTestMapper extends Serializable {
    List<SysTest> selectAll();
}
