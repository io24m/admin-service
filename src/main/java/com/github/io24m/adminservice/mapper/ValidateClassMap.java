package com.github.io24m.adminservice.mapper;

import com.github.io24m.adminservice.domain.ValidateClass;

import java.util.List;

public interface ValidateClassMap {
    int deleteByPrimaryKey(String classType);

    int insert(ValidateClass record);

    int insertSelective(ValidateClass record);

    ValidateClass selectByPrimaryKey(String classType);

    List<ValidateClass> selectAll();

    int updateByPrimaryKeySelective(ValidateClass record);

    int updateByPrimaryKey(ValidateClass record);
}