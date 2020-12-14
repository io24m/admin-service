package com.github.io24m.adminservice.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author lk1
 * @description
 * @create 2020-12-14 14:59
 */
public class AESUtil {
    private final static String key = "Ae328yfhUY8truSE" ;
    private final static String iv = "EJ9yfhUY8trUDfv3" ;

    public static String Encrypt(String s) {
        try {
            byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] ivByte = iv.getBytes(StandardCharsets.UTF_8);
            IvParameterSpec iv = new IvParameterSpec(ivByte);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            byte[] encrype = cipher.doFinal(s.getBytes());
            return Base64.getEncoder().encodeToString(encrype);
        } catch (Exception e) {
            return null;
        }
    }

    public static String Decrypt(String s) {
        try {
            byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivp = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivp);
            byte[] encrype = Base64.getDecoder().decode(s);
            byte[] origin = cipher.doFinal(encrype);
            String str = new String(origin);
            return str;

        } catch (Exception e) {
            return null;
        }
    }
}
