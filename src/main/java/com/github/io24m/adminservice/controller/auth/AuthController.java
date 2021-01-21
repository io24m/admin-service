package com.github.io24m.adminservice.controller.auth;

import com.github.io24m.adminservice.common.annotation.JsonProperty;
import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.common.utils.AESUtil;
import com.github.io24m.adminservice.common.utils.MD5Util;
import com.github.io24m.adminservice.common.utils.TokenUtil;
import com.github.io24m.adminservice.domain.SysUser;
import com.github.io24m.adminservice.service.sys.UserService;
import org.apache.commons.lang3.StringUtils;
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
    public AjaxResponse login(@JsonProperty String account, @JsonProperty String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return AjaxResponse.error("用户名或密码错误");
        }
        String md5 = MD5Util.getMD5(password);
        SysUser user = userService.getUser(account, md5);
        if (user == null) {
            return AjaxResponse.error("用户名或密码错误");
        }
        String token = TokenUtil.getToken(user.getAccount(), user.getPassword());
        token = AESUtil.Encrypt(token);
        //加密token
        return AjaxResponse.result(token);
    }

    @PostMapping("/data")
    public AjaxResponse authData() {
        return AjaxResponse.success();
    }
}
