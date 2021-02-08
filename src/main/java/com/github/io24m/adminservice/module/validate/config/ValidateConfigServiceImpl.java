package com.github.io24m.adminservice.module.validate.config;

import com.github.io24m.adminservice.domain.ValidateConfig;
import com.github.io24m.adminservice.mapper.ValidateConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 10:42
 */
@Service
public class ValidateConfigServiceImpl {

    @Autowired
    private ValidateConfigMapper validateConfigMapper;

    public Object getConfig() {
        List<ValidateConfig> validateConfigs = validateConfigMapper.selectAll();
        Map<String, Map<String, List<ValidateConfig>>> collect = validateConfigs.stream()
                .collect(Collectors
                        .groupingBy(ValidateConfig::getClassName,
                                Collectors.groupingBy(ValidateConfig::getKey, Collectors.toList())));


        return collect;
    }
}
