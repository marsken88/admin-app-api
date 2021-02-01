package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.LoginDetailDTO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/28 3:28 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface LoginService {

    LoginDetailDTO login(String loginName, String loginPwd);
}
