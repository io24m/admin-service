package com.github.io24m.adminservice.module.validate.data;

import com.github.io24m.adminservice.module.validate.Person;
import com.github.io24m.validate4java.Validate;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validator.dict.DictConfigValidator;
import com.github.io24m.validate4java.validator.empty.EmptyConfigValidator;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 13:25
 */
@Service
public class ValidateDataServiceImpl {
    public Message validate(Person person) {
        Validate validate = new Validate();
        validate.config(new EmptyConfigValidator(new HashMap<>()));
        validate.config(new DictConfigValidator(null, new HashMap<>()));
        ValidateResult handle = validate.handle(person);
        Message message = new Message();
        message.setErrorMessage(handle.getErrorMessage());
        message.setMessage(handle.getMessage());
        message.setSuccess(handle.success());
        return message;
    }
}
