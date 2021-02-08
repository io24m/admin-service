package com.github.io24m.adminservice.mapper;

import com.github.io24m.adminservice.domain.ValidateFileConfig;

import java.util.List;

public interface ValidateFileConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ValidateFileConfig record);

    int insertSelective(ValidateFileConfig record);

    ValidateFileConfig selectByPrimaryKey(Integer id);

    List<ValidateFileConfig> selectAll();

    int updateByPrimaryKeySelective(ValidateFileConfig record);

    int updateByPrimaryKey(ValidateFileConfig record);
}