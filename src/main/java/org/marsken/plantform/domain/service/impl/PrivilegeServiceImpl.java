package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.controller.dto.PrivilegeMenuDTO;
import org.marsken.plantform.controller.dto.PrivilegeUrlDTO;
import org.marsken.plantform.convertor.PrivilegeConvertor;
import org.marsken.plantform.domain.service.PrivilegeService;
import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;
import org.marsken.plantform.infrastructure.mapper.PrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 3:08 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Override
    public List<PrivilegeUrlDTO> findAll() {
        List<PrivilegeUrlDTO> privilegeUrlDTOList = new ArrayList<>();
        List<PrivilegeDO> privilegeDOList = privilegeMapper.findByType(1);
        for (PrivilegeDO privilegeDO : privilegeDOList) {
            PrivilegeUrlDTO privilegeUrlDTO = new PrivilegeUrlDTO();
            privilegeUrlDTO.setUrl(privilegeDO.getUrl());
            privilegeUrlDTO.setComment(privilegeDO.getUrl());
            privilegeUrlDTO.setName(privilegeDO.getName());
            privilegeUrlDTOList.add(privilegeUrlDTO);
        }
        return privilegeUrlDTOList;
    }

    @Override
    public List<PrivilegeMenuDTO> findMenuByType() {
        List<PrivilegeDO> privilegeDOList = privilegeMapper.findByType(1);
        List<PrivilegeMenuDTO> privilegeMenuDTOList = privilegeConvertor.toDTOList(privilegeDOList);
        return privilegeMenuDTOList;
    }

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Autowired
    private PrivilegeConvertor privilegeConvertor;
}
