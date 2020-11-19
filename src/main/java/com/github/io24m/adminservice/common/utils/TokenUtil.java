package com.github.io24m.adminservice.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.io24m.adminservice.common.dto.User;

/**
 * @author lk1
 * @description
 * @create 2020-11-19 14:26
 */
public final class TokenUtil {

    /**
     * 根据用户生成token
     *
     * @param user
     * @return
     */
    public static String getToken(User user) {
        String token = JWT.create().withAudience(user.getUserId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
