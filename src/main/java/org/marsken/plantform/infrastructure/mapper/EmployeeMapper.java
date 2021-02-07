package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.controller.dto.EmployeeQueryDTO;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 1:32 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface EmployeeMapper {

    List<EmployeeDO> findAll();

    EmployeeDO findByLoginNameAndLoginPwd(String loginName, String loginPwd);

    List<EmployeeDO> findEmployeeByQueryDTO(EmployeeQueryDTO employeeQueryDTO);
}
