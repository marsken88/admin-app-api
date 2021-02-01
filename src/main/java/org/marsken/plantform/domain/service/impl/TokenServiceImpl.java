package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.domain.service.TokenService;
import org.marsken.plantform.domain.util.JwtUtil;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.springframework.stereotype.Service;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 3:30 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class TokenServiceImpl implements TokenService {


    @Override
    public String generateToken(EmployeeDO employeeDO) {
        JwtUtil.createJWT(employeeDO.getId(), "marsken", employeeDO.getLoginName(), 6000L);
        return null;
    }
}
