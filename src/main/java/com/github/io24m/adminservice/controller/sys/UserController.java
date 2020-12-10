package com.github.io24m.adminservice.controller.sys;

import com.github.io24m.adminservice.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2020-12-10 14:27
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public boolean getUser() {
        userService.getUser();
        return true;
    }
}
