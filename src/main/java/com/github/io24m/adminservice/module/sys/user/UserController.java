package com.github.io24m.adminservice.module.sys.user;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2020-12-10 14:27
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户信息")
    @PostMapping("")
    public AjaxResponse getUser() {
        return AjaxResponse.result(userService.getUser());
    }
}
