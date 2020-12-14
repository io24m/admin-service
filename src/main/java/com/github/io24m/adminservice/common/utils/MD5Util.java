package com.github.io24m.adminservice.common.utils;

import org.springframework.util.DigestUtils;

/**
 * @author lk1
 * @description
 * @create 2020-12-14 14:25
 */
public class MD5Util {
    private static final String slat = "&%5123***&&%%$$#@" ;

    public static String getMD5(String str) {
        String base = str + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public static String getMD5(String str, String slat) {
        String base = str + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
