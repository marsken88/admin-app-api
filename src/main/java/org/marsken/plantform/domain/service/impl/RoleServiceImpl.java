package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.convertor.RoleConvertor;
import org.marsken.plantform.domain.service.RoleService;
import org.marsken.plantform.infrastructure.dataobject.RoleDO;
import org.marsken.plantform.infrastructure.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:03 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Override
    public List<RoleDTO> findAllRole() {
        List<RoleDO> roleDOList = roleMapper.findAll();
        return roleConvertor.toDTOList(roleDOList);
    }

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConvertor roleConvertor;
}
