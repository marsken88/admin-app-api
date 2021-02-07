package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.marsken.plantform.controller.dto.PositionDTO;
import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.controller.dto.RoleSelectedDTO;
import org.marsken.plantform.infrastructure.dataobject.PositionDO;
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
public interface PositionConvertor {
    PositionDTO toDTO(PositionDO positionDO);

    List<PositionDTO> toDTOList(List<PositionDO> positionDOList);

}
