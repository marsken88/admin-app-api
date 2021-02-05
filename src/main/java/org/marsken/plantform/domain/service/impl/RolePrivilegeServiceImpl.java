package org.marsken.plantform.domain.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.marsken.plantform.controller.dto.RolePrivilegeSimpleDTO;
import org.marsken.plantform.controller.dto.RolePrivilegeTreeDTO;
import org.marsken.plantform.domain.service.RolePrivilegeService;
import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;
import org.marsken.plantform.infrastructure.mapper.PrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 5:36 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {
    @Override
    public RolePrivilegeTreeDTO listPrivilegeByRoleId(Long roleId) {
        RolePrivilegeTreeDTO rolePrivilegeTreeDTO = new RolePrivilegeTreeDTO();
        List<PrivilegeDO> privilegeDOList = privilegeMapper.findAll();
        List<PrivilegeDO> rootPrivilegeDOList = privilegeDOList.stream()
                .filter(e -> e.getParentKey() == null).collect(Collectors.toList());
        List<RolePrivilegeSimpleDTO> rootTreeList = new ArrayList<>();
        List<String> parentKeyList = new ArrayList<>();
        for (PrivilegeDO rootPrivilegeDO : rootPrivilegeDOList) {
            RolePrivilegeSimpleDTO rootRolePrivilegeSimpleDTO = new RolePrivilegeSimpleDTO();
            parentKeyList.add(rootPrivilegeDO.getKey());
            rootRolePrivilegeSimpleDTO.setKey(rootPrivilegeDO.getKey());
            rootRolePrivilegeSimpleDTO.setName(rootPrivilegeDO.getName());
            rootRolePrivilegeSimpleDTO.setParentKey(rootPrivilegeDO.getParentKey());
            rootRolePrivilegeSimpleDTO.setSort(rootPrivilegeDO.getSort());
            rootRolePrivilegeSimpleDTO.setType(rootPrivilegeDO.getType());
            rootRolePrivilegeSimpleDTO.setUrl(rootPrivilegeDO.getUrl());
            rootTreeList.add(rootRolePrivilegeSimpleDTO);
            for (PrivilegeDO privilegeDO : privilegeDOList) {
                if (privilegeDO.getParentKey().equals(rootPrivilegeDO.getKey())) {
                    RolePrivilegeSimpleDTO rolePrivilegeSimpleDTO = new RolePrivilegeSimpleDTO();
                    parentKeyList.add(rootPrivilegeDO.getKey());
                    rolePrivilegeSimpleDTO.setKey(rootPrivilegeDO.getKey());
                    rolePrivilegeSimpleDTO.setName(rootPrivilegeDO.getName());
                    rolePrivilegeSimpleDTO.setParentKey(rootPrivilegeDO.getParentKey());
                    rolePrivilegeSimpleDTO.setSort(rootPrivilegeDO.getSort());
                    rolePrivilegeSimpleDTO.setType(rootPrivilegeDO.getType());
                    rolePrivilegeSimpleDTO.setUrl(rootPrivilegeDO.getUrl());
                    if (CollectionUtils.isEmpty(rootRolePrivilegeSimpleDTO.getChildren())) {
                        rootRolePrivilegeSimpleDTO.setChildren(Arrays.asList(rolePrivilegeSimpleDTO));
                    }else {
                        rootRolePrivilegeSimpleDTO.getChildren().add(rolePrivilegeSimpleDTO);
                    }
                }
            }
            rolePrivilegeTreeDTO.setRoleId(roleId);
            rolePrivilegeTreeDTO.setPrivileges(rootTreeList);
            return rolePrivilegeTreeDTO;
        }


        return null;
    }

    @Autowired
    private PrivilegeMapper privilegeMapper;
}
