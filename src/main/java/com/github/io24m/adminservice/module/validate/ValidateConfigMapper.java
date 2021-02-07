package com.github.io24m.adminservice.module.validate;

import com.github.io24m.adminservice.module.validate.config.ValidateConfig;

import java.util.List;

public interface ValidateConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ValidateConfig record);

    int insertSelective(ValidateConfig record);

    ValidateConfig selectByPrimaryKey(Integer id);

    List<ValidateConfig> selectAll();

    int updateByPrimaryKeySelective(ValidateConfig record);

    int updateByPrimaryKey(ValidateConfig record);
}