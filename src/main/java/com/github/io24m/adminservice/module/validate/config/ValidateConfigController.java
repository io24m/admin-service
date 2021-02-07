package com.github.io24m.adminservice.module.validate.config;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 9:44
 */
@RestController
@RequestMapping("/validate/config")
public class ValidateConfigController {
    @Autowired
    private ValidateConfigServiceImpl validateConfigService;

    @PostMapping("")
    public AjaxResponse get() {
        Object config = validateConfigService.getConfig();
        return AjaxResponse.result(config);
    }

    @PostMapping("/update")
    public AjaxResponse update() {
        return AjaxResponse.success();
    }
}
