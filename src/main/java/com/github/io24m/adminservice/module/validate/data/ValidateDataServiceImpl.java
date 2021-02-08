package com.github.io24m.adminservice.module.validate.data;

import com.github.io24m.adminservice.domain.ValidateClass;
import com.github.io24m.adminservice.domain.ValidateFileConfig;
import com.github.io24m.adminservice.mapper.ValidateClassMapper;
import com.github.io24m.adminservice.mapper.ValidateFileConfigMapper;
import com.github.io24m.validate4java.Validate;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validator.dict.DictConfig;
import com.github.io24m.validate4java.validator.dict.DictConfigValidator;
import com.github.io24m.validate4java.validator.empty.EmptyConfig;
import com.github.io24m.validate4java.validator.empty.EmptyConfigValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 13:25
 */
@Service
public class ValidateDataServiceImpl {
    @Autowired
    private ValidateClassMapper validateClassMapper;

    @Autowired
    private ValidateFileConfigMapper validateFileConfigMapper;

    public Message validate(Person person) {
        PersonConfig config = getConfig();
        Validate validate = new Validate();
        validate.config(new EmptyConfigValidator(config.getEmptyConfigMap()));
        validate.config(new DictConfigValidator(getDictMap(), config.getDictConfigMap()));
        ValidateResult handle = validate.handle(person);
        Message message = new Message();
        message.setErrorMessage(handle.getErrorMessage());
        message.setMessage(handle.getMessage());
        message.setSuccess(handle.success());
        return message;
    }

    private Map<String, Set<String>> getDictMap() {
        Map<String, Set<String>> res = new HashMap<>();
        Set<String> s = new HashSet<>();
        s.add("1");
        s.add("2");
        s.add("3");
        res.put("name", s);
        res.put("age", s);
        return res;
    }

    private PersonConfig getConfig() {
        PersonConfig config = new PersonConfig();

        List<ValidateClass> classConfig = getClassConfig();
        Set<String> classConfigSet = classConfig.stream()
                .map(ValidateClass::getClassType)
                .collect(Collectors.toSet());

        List<ValidateFileConfig> fileConfig = getFileConfig();
        fileConfig = fileConfig.stream()
                .filter(x -> classConfigSet.contains(x.getClassType()))
                .collect(Collectors.toList());

        Map<String, EmptyConfig> empty = fileConfig.stream()
                .filter(x -> x.getValidateType().equals("empty"))
                .collect(Collectors.toMap(ValidateFileConfig::getFileKey, v -> {
                    EmptyConfig emptyConfig = new EmptyConfig();
                    emptyConfig.setCheck(v.getCheck());
                    emptyConfig.setPass(v.getPass());
                    emptyConfig.setErrorMessage(v.getErrorMessage());
                    return emptyConfig;
                }));
        config.setEmptyConfigMap(empty);


        Map<String, DictConfig> dict = fileConfig.stream()
                .filter(x -> x.getValidateType().equals("dict"))
                .collect(Collectors.toMap(ValidateFileConfig::getFileKey, v -> {
                    DictConfig dictConfig = new DictConfig();
                    dictConfig.setCheck(v.getCheck());
                    dictConfig.setPass(v.getPass());
                    dictConfig.setErrorMessage(v.getErrorMessage());
                    return dictConfig;
                }));
        config.setDictConfigMap(dict);


        return config;
    }

    private List<ValidateClass> getClassConfig() {
        return validateClassMapper.selectAll();
    }

    private List<ValidateFileConfig> getFileConfig() {
        return validateFileConfigMapper.selectAll();
    }
}
