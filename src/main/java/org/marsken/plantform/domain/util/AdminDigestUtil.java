package org.marsken.plantform.domain.util;


import org.marsken.plantform.domain.constant.CommonConstant;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 2:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class AdminDigestUtil extends DigestUtils {

    public static String encryptPassword(String salt, String password) {
        return AdminDigestUtil.md5DigestAsHex(String.format(salt, password).getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        String encryptPassword = AdminDigestUtil.encryptPassword(CommonConstant.SALT_FORMAT, "123456");
        String encryptPassword1 = AdminDigestUtil.encryptPassword(CommonConstant.SALT_FORMAT, "888888");
        System.out.println(encryptPassword);
        System.out.println(encryptPassword1);
    }
}
