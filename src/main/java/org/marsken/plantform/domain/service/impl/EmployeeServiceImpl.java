package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeQueryDTO;
import org.marsken.plantform.convertor.EmployeeConvertor;
import org.marsken.plantform.domain.service.EmployeeService;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageInfo<EmployeeDTO> findEmployeeByQuery(EmployeeQueryDTO employeeQueryDTO) {
        Page page = PageHelper.startPage(employeeQueryDTO.getPageNum(), employeeQueryDTO.getPageSize());
        List<EmployeeDO> employeeDOList = employeeMapper.findEmployeeByQueryDTO(employeeQueryDTO);
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(employeeConvertor.toDTOList(employeeDOList));
        return pageInfo;
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeConvertor employeeConvertor;
}
