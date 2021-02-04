package org.marsken.plantform.domain.service.impl;

import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.marsken.plantform.controller.dto.LoginDetailDTO;
import org.marsken.plantform.controller.dto.LoginPrivilegeDTO;
import org.marsken.plantform.domain.constant.CommonConstant;
import org.marsken.plantform.domain.constant.PrivilegeTypeEnum;
import org.marsken.plantform.domain.service.LoginService;
import org.marsken.plantform.domain.service.TokenService;
import org.marsken.plantform.domain.util.AdminDigestUtil;
import org.marsken.plantform.domain.util.AdminStringUtil;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;
import org.marsken.plantform.infrastructure.mapper.EmployeeMapper;
import org.marsken.plantform.infrastructure.mapper.PrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/28 3:28 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginDetailDTO login(String loginName, String loginPwd) {
        String encryptPassword = AdminDigestUtil.encryptPassword(CommonConstant.SALT_FORMAT, loginPwd);
        EmployeeDO employeeDO = employeeMapper.findByLoginNameAndLoginPwd(loginName, encryptPassword);

        LoginDetailDTO loginDetailDTO = new LoginDetailDTO();
        loginDetailDTO.setId(employeeDO.getId());
        loginDetailDTO.setLoginName(employeeDO.getLoginName());
        loginDetailDTO.setNickName(employeeDO.getNickName());
        loginDetailDTO.setActualName(employeeDO.getActualName());
        loginDetailDTO.setIsSuperMan(Boolean.TRUE);
        loginDetailDTO.setXAccessToken(tokenService.generateToken(employeeDO));

        List<PrivilegeDO> privilegeDOList = privilegeMapper.findAll();

        List<LoginPrivilegeDTO> loginPrivilegeDTOList = new ArrayList<>();
        for (PrivilegeDO privilegeDO : privilegeDOList) {
            LoginPrivilegeDTO loginPrivilegeDTO = new LoginPrivilegeDTO();
            loginPrivilegeDTO.setKey(privilegeDO.getKey());
            loginPrivilegeDTO.setType(privilegeDO.getType());
            loginPrivilegeDTO.setUrl(privilegeDO.getUrl());
            loginPrivilegeDTO.setParentKey(privilegeDO.getParentKey());
            loginPrivilegeDTOList.add(loginPrivilegeDTO);
        }

        loginDetailDTO.setPrivilegeList(loginPrivilegeDTOList);
        stringRedisTemplate.opsForValue().set(loginDetailDTO.getLoginName(), new Gson().toJson(loginDetailDTO), 60L, TimeUnit.SECONDS);
        return loginDetailDTO;
    }

    @Override
    public LoginDetailDTO findByToken(String token) {
        String loginName = tokenService.parsToken(token);
        if (Objects.nonNull(loginName)) {
            String result = stringRedisTemplate.opsForValue().get(loginName);
            if (Objects.nonNull(result)) {
                LoginDetailDTO loginDetailDTO = new Gson().fromJson(result, LoginDetailDTO.class);
                return loginDetailDTO;
            }
        }
        return null;
    }

    @Override
    public Boolean logout(String token) {
        try {
            String loginName = tokenService.parsToken(token);
            stringRedisTemplate.delete(loginName);
        } catch (Exception e) {

        }
        return Boolean.TRUE;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private EmployeeMapper employeeMapper;
}
