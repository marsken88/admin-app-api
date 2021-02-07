package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.controller.dto.DepartmentDTO;
import org.marsken.plantform.convertor.DepartmentConvertor;
import org.marsken.plantform.domain.service.DepartmentService;
import org.marsken.plantform.infrastructure.dataobject.DepartmentDO;
import org.marsken.plantform.infrastructure.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<DepartmentDTO> findAll() {
        List<DepartmentDO> departmentDOList = departmentMapper.findAll();
        return departmentConvertor.toDTOList(departmentDOList);
    }

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentConvertor departmentConvertor;
}
