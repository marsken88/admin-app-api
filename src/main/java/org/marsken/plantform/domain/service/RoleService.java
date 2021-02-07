package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.RoleAddDTO;
import org.marsken.plantform.controller.dto.RoleDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:03 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface RoleService {

    List<RoleDTO> findAllRole();

    Boolean save(RoleAddDTO roleAddDTO);
}
