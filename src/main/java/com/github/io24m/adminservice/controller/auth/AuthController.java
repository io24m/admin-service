package com.github.io24m.adminservice.controller.auth;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.common.utils.TokenUtil;
import com.github.io24m.adminservice.domain.SysUser;
import com.github.io24m.adminservice.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:12
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @SkipToken
    public AjaxResponse login(String account, String password) {
        SysUser user = userService.getUser(account, password);
        if (user == null) {
            return AjaxResponse.error("user error");
        }
        String token = TokenUtil.getToken(user.getAccount(), user.getPassword());
        return AjaxResponse.result(token);
    }
}
