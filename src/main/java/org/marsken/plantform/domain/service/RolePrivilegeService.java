package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.RolePrivilegeTreeDTO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 5:36 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface RolePrivilegeService {

   RolePrivilegeTreeDTO listPrivilegeByRoleId(Long roleId);
}
