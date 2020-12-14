package com.github.io24m.adminservice.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author lk1
 * @description
 * @create 2020-11-19 14:26
 */
public final class TokenUtil {

    /**
     * 根据用户生成token
     */
    public static String getToken(String account, String password) {
        String token = JWT.create()
                .withAudience(account)
                .sign(Algorithm.HMAC256(password));
        return token;
    }
}
