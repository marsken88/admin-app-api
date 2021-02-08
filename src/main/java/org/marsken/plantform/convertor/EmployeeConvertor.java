package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.marsken.plantform.controller.dto.EmployeeAddDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.dataobject.RoleDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/6 12:06 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface EmployeeConvertor {
    EmployeeDTO toDTO(EmployeeDO employeeDO);

    List<EmployeeDTO> toDTOList(List<EmployeeDO> employeeDOList);

    EmployeeDO toDO(EmployeeAddDTO employeeAddDTO);
}
