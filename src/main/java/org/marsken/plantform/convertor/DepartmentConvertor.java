package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.marsken.plantform.controller.dto.DepartmentDTO;
import org.marsken.plantform.infrastructure.dataobject.DepartmentDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/6 12:06 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface DepartmentConvertor {
    DepartmentDTO toDTO(DepartmentDO departmentDO);

    List<DepartmentDTO> toDTOList(List<DepartmentDO> departmentDOList);
}
