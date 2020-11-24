package com.github.io24m.adminservice.mapper.home;

import com.github.io24m.adminservice.domain.home.Home;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:08
 */
public interface HomeMapper {
    List<Home> selectAll();
}
