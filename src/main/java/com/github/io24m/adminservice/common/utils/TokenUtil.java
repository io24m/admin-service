package com.github.io24m.adminservice.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

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
        Date date = new Date();
        String token = JWT.create()
                .withAudience(account)
                .withIssuedAt(date)
                .withNotBefore(date)
//                .withExpiresAt()
//                .withClaim("iat", date)
//                .withClaim("nbf", date)
                .sign(Algorithm.HMAC256(password));
        return token;
    }
}
