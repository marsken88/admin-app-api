package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.EmployeeAddDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeQueryDTO;
import org.marsken.plantform.controller.dto.PositionRelationAddDTO;
import org.marsken.plantform.convertor.EmployeeConvertor;
import org.marsken.plantform.domain.constant.CommonConstant;
import org.marsken.plantform.domain.service.EmployeeService;
import org.marsken.plantform.domain.service.PositionRelationService;
import org.marsken.plantform.domain.util.AdminDigestUtil;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    @Override
    public Boolean save(EmployeeAddDTO employeeAddDTO) {
        if(StringUtils.isEmpty(employeeAddDTO.getBirthday())){
            employeeAddDTO.setBirthday(null);
        }
        EmployeeDO employeeDO = employeeConvertor.toDO(employeeAddDTO);
        employeeDO.setLoginPwd(AdminDigestUtil.encryptPassword(CommonConstant.SALT_FORMAT, employeeAddDTO.getLoginPwd()));
        employeeDO.setCreateUser(1L);
        Long employeeId = employeeMapper.save(employeeDO);
        PositionRelationAddDTO positionRelationAddDTO = new PositionRelationAddDTO();
        positionRelationAddDTO.setEmployeeId(employeeId);
        positionRelationAddDTO.setPositionIdList(employeeAddDTO.getPositionIdList());

        positionRelationService.savePositionRelation(positionRelationAddDTO);
        return Boolean.TRUE;
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeConvertor employeeConvertor;

    @Autowired
    private PositionRelationService positionRelationService;
}
