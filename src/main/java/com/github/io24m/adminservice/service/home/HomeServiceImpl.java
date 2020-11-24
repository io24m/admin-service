package com.github.io24m.adminservice.service.home;

import com.github.io24m.adminservice.domain.home.Home;
import com.github.io24m.adminservice.mapper.home.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:03
 */
@Service
public class HomeServiceImpl {
    @Autowired
    private HomeMapper homeMapper;

    public List<Home> get() {
        List<Home> homeResults = homeMapper.selectAll();
        return homeResults;
    }

    public List<Home> selectAll() {
        return get();
    }
}
