package org.marsken.plantform.domain.service.impl;

import org.marsken.arch.core.clientobject.PageResultDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeQueryDTO;
import org.marsken.plantform.domain.service.EmployeeService;
import org.marsken.plantform.infrastructure.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 1:45 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public PageResultDTO<EmployeeDTO> findEmployeeByQuery(EmployeeQueryDTO employeeQueryDTO) {

        return null;
    }

    @Autowired
    private EmployeeMapper employeeMapper;
}
