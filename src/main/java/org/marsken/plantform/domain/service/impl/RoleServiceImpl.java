package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.controller.dto.RoleAddDTO;
import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.convertor.RoleConvertor;
import org.marsken.plantform.domain.service.RoleService;
import org.marsken.plantform.infrastructure.dataobject.RoleDO;
import org.marsken.plantform.infrastructure.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Boolean save(RoleAddDTO roleAddDTO) {
        RoleDO roleDO = new RoleDO();
        roleDO.setRoleName(roleAddDTO.getRoleName());
        roleDO.setRemark(roleAddDTO.getRemark());
        Date now = new Date();
        roleDO.setCreateTime(now);
        roleDO.setUpdateTime(now);
        roleMapper.save(roleDO);
        return Boolean.TRUE;
    }

    @Override
    public RoleDTO findById(Long roleId) {
        RoleDO roleDO = roleMapper.findById(roleId);
        return roleConvertor.toDTO(roleDO);
    }

    @Override
    public Boolean removeById(Long id) {
        roleMapper.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(RoleAddDTO roleAddDTO) {
        roleMapper.updateRoleNameAndRemarkById(roleAddDTO.getRoleName(), roleAddDTO.getRemark(), roleAddDTO.getId());
        return Boolean.TRUE;
    }

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConvertor roleConvertor;
}
