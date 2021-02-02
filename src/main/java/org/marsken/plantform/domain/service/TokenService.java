package org.marsken.plantform.domain.service;

import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 3:29 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface TokenService {

    String generateToken(EmployeeDO employeeDO);

    String parsToken(String token);
}
