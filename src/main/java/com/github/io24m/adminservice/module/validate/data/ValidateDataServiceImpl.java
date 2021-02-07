package com.github.io24m.adminservice.module.validate.data;

import com.github.io24m.adminservice.module.validate.Person;
import com.github.io24m.adminservice.module.validate.ValidateConfigMapper;
import com.github.io24m.adminservice.module.validate.config.ValidateConfig;
import com.github.io24m.validate4java.Validate;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validator.dict.DictConfig;
import com.github.io24m.validate4java.validator.dict.DictConfigValidator;
import com.github.io24m.validate4java.validator.empty.EmptyConfig;
import com.github.io24m.validate4java.validator.empty.EmptyConfigValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 13:25
 */
@Service
public class ValidateDataServiceImpl {

    @Autowired
    private ValidateConfigMapper validateConfigMapper;

    public Message validate(Person person) {
        PersonConfig config = getConfig();
        Validate validate = new Validate();
        validate.config(new EmptyConfigValidator(config.getEmptyConfigMap()));
        validate.config(new DictConfigValidator(null, config.getDictConfigMap()));
        ValidateResult handle = validate.handle(person);
        Message message = new Message();
        message.setErrorMessage(handle.getErrorMessage());
        message.setMessage(handle.getMessage());
        message.setSuccess(handle.success());
        return message;
    }

    private PersonConfig getConfig() {
        PersonConfig config = new PersonConfig();
        List<ValidateConfig> validateConfigs = validateConfigMapper.selectAll();
        Map<String, EmptyConfig> empty = validateConfigs.stream()
                .filter(x -> x.getValidateType().equals("empty"))
                .collect(Collectors.toMap(ValidateConfig::getKey, v -> {
                    EmptyConfig emptyConfig = new EmptyConfig();
                    emptyConfig.setCheck(v.getCheck());
                    emptyConfig.setPass(v.getPass());
                    emptyConfig.setErrorMessage(v.getErrorMessage());
                    return emptyConfig;
                }));
        config.setEmptyConfigMap(empty);
        Map<String, DictConfig> dict = validateConfigs.stream()
                .filter(x -> x.getValidateType().equals("dict"))
                .collect(Collectors.toMap(ValidateConfig::getKey, v -> {
                    DictConfig dictConfig = new DictConfig();
                    dictConfig.setCheck(v.getCheck());
                    dictConfig.setPass(v.getPass());
                    dictConfig.setErrorMessage(v.getErrorMessage());
                    return dictConfig;
                }));
        config.setDictConfigMap(dict);
        return config;
    }

}
