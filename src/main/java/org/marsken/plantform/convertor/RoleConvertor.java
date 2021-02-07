package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.controller.dto.RoleSelectedDTO;
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
public interface RoleConvertor {
    RoleDTO toDTO(RoleDO roleDO);

    List<RoleDTO> toDTOList(List<RoleDO> roleDOList);

    @Named(value = "toSelectedDTO")
    RoleSelectedDTO toSelectedDTO(RoleDO roleDO);

    List<RoleSelectedDTO> toSelectedDTOList(List<RoleDO> roleDOList);
}
