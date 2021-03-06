package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.controller.dto.RoleQueryDTO;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.dataobject.RoleEmployeeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:01 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface RoleEmployeeMapper {

   List<EmployeeDO> findEmployeeByNamePage(RoleQueryDTO roleQueryDTO);

   List<EmployeeDO> findEmployeeByRoleId(Long roleId);

   List<Long> findRoleIdsByEmployeeId(Long employeeId);

   Integer removeByEmployeeId(Long employeeId);

   Integer saveBatch(List<RoleEmployeeDO> roleEmployeeDOList);

}
