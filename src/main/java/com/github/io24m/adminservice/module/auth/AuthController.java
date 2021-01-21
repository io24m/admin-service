package com.github.io24m.adminservice.module.auth;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.common.utils.AESUtil;
import com.github.io24m.adminservice.common.utils.MD5Util;
import com.github.io24m.adminservice.common.utils.TokenUtil;
import com.github.io24m.adminservice.module.sys.user.SysUser;
import com.github.io24m.adminservice.module.sys.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:12
 */
@Api(description = "权限管理")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    @SkipToken
    public AjaxResponse login(@RequestParam String account, @RequestParam String password) {
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

    @ApiOperation("权限数据")
    @PostMapping("/data")
    public AjaxResponse authData() {
        return AjaxResponse.success();
    }
}
