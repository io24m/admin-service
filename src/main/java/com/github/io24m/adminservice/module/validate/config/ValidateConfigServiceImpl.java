package com.github.io24m.adminservice.module.validate.config;

import com.github.io24m.adminservice.domain.ValidateClass;
import com.github.io24m.adminservice.domain.ValidateFileConfig;
import com.github.io24m.adminservice.mapper.ValidateClassMapper;
import com.github.io24m.adminservice.mapper.ValidateFileConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 10:42
 */
@Service
public class ValidateConfigServiceImpl {

    @Autowired
    private ValidateClassMapper validateClassMapper;

    @Autowired
    private ValidateFileConfigMapper validateFileConfigMapper;


    public List<ValidateClass> getClassConfig() {
        return validateClassMapper.selectAll();
    }

    public List<ValidateFileConfig> getFileConfig(String classType) {
        List<ValidateFileConfig> validateFileConfigs = validateFileConfigMapper.selectAll();
        List<ValidateFileConfig> res = validateFileConfigs.stream()
                .filter(x -> x.getClassType().equals(classType)).collect(Collectors.toList());
        return res;
    }
}
