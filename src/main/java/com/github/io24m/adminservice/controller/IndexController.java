package com.github.io24m.adminservice.controller;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-01-21 12:36
 */
@RestController
@RequestMapping("")
public class IndexController {
    @SkipToken
    @GetMapping("")
    public AjaxResponse index() {
        return AjaxResponse.success();
    }
}
