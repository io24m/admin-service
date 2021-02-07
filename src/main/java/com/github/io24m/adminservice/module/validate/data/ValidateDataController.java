package com.github.io24m.adminservice.module.validate.data;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.module.validate.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 9:42
 */
@RestController
@RequestMapping("/validate/data")
public class ValidateDataController {
    @Autowired
    private ValidateDataServiceImpl validateDataService;

    @PostMapping("")
    public AjaxResponse validate(@RequestBody Person person) {
        Message message = validateDataService.validate(person);
        return AjaxResponse.result(message);
    }
}
