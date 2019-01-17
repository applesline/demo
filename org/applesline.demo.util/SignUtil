package org.applesline.demo.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuyaping
 * 创建时间:2018年07月12日
 */
public class SignUtil {

    private static final String secret = "your_secret";
    /**
     * 签名生成算法
     *
     * @param params
     * @return
     * @throws IOException
     */
    public static String getSignature(Map<String,String> params) throws IOException {
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        StringBuilder baseParams = new StringBuilder();
        for (Map.Entry<String, String> param : sortedParams.entrySet()) {
            baseParams.append(param.getKey()).append("=").append(param.getValue());
        }
        baseParams.append(secret);

        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(String.valueOf(baseParams).getBytes("UTF-8"));
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }

        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }

    /**
     * 校验参数签名是否正确
     *
     * @param params 参数。
     * @param sign 签名。
     * @return
     */
    public static boolean checkSign(Map<String,String> params,String sign) {
        try {
            String signedParams = getSignature(params);
            return signedParams.equals(sign);
        } catch (Exception e) {
            return false;
        }
    }

}
