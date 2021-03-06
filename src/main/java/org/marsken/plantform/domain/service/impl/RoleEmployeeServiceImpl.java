package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeUpdateRolesDTO;
import org.marsken.plantform.controller.dto.RoleQueryDTO;
import org.marsken.plantform.controller.dto.RoleSelectedDTO;
import org.marsken.plantform.convertor.EmployeeConvertor;
import org.marsken.plantform.convertor.RoleConvertor;
import org.marsken.plantform.domain.service.RoleEmployeeService;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.dataobject.RoleDO;
import org.marsken.plantform.infrastructure.dataobject.RoleEmployeeDO;
import org.marsken.plantform.infrastructure.mapper.RoleEmployeeMapper;
import org.marsken.plantform.infrastructure.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 2:09 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class RoleEmployeeServiceImpl implements RoleEmployeeService {

    @Override
    public PageInfo<EmployeeDTO> findEmployeeByNamePage(RoleQueryDTO roleQueryDTO) {
        Page page = PageHelper.startPage(roleQueryDTO.getPageNum(), roleQueryDTO.getPageSize());
        List<EmployeeDO> employeeDOList = roleEmployeeMapper.findEmployeeByNamePage(roleQueryDTO);
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(employeeConvertor.toDTOList(employeeDOList));
        return pageInfo;
    }

    @Override
    public List<EmployeeDTO> findEmployeeByRoleId(Long roleId) {
        List<EmployeeDO> employeeDOList = roleEmployeeMapper.findEmployeeByRoleId(roleId);
        return employeeConvertor.toDTOList(employeeDOList);
    }

    @Override
    public List<RoleSelectedDTO> findRoleByEmployeeId(Long employeeId) {
        List<Long> roleIdList = roleEmployeeMapper.findRoleIdsByEmployeeId(employeeId);
        List<RoleDO> roleDOList = roleMapper.findAll();
        List<RoleSelectedDTO> roleSelectedDTOList = roleConvertor.toSelectedDTOList(roleDOList);
        roleSelectedDTOList.forEach(roleDTO -> roleDTO.setSelected(roleIdList.contains(roleDTO.getId())));
        return roleSelectedDTOList;
    }

    @Transactional
    @Override
    public Boolean updateRoles(EmployeeUpdateRolesDTO employeeUpdateRolesDTO) {
        List<RoleEmployeeDO> roleEmployeeDOList = new ArrayList<>();
        for (Long roleId : employeeUpdateRolesDTO.getRoleIds()) {
            RoleEmployeeDO roleEmployeeDO = new RoleEmployeeDO();
            roleEmployeeDO.setEmployeeId(employeeUpdateRolesDTO.getEmployeeId());
            roleEmployeeDO.setRoleId(roleId);
            roleEmployeeDOList.add(roleEmployeeDO);
        }
        roleEmployeeMapper.removeByEmployeeId(employeeUpdateRolesDTO.getEmployeeId());
        roleEmployeeMapper.saveBatch(roleEmployeeDOList);
        return Boolean.TRUE;
    }


    @Autowired
    private RoleEmployeeMapper roleEmployeeMapper;

    @Autowired
    private EmployeeConvertor employeeConvertor;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConvertor roleConvertor;
}
