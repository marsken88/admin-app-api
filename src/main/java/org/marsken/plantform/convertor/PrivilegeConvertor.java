package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.marsken.plantform.controller.dto.PositionDTO;
import org.marsken.plantform.controller.dto.PrivilegeMenuDTO;
import org.marsken.plantform.infrastructure.dataobject.PositionDO;
import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/6 12:06 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface PrivilegeConvertor {
    PrivilegeMenuDTO toDTO(PrivilegeDO privilegeDO);

    List<PrivilegeMenuDTO> toDTOList(List<PrivilegeDO> privilegeDOList);

}
