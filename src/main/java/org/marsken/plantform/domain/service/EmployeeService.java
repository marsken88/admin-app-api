package org.marsken.plantform.domain.service;

import org.marsken.arch.core.clientobject.PageResultDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeQueryDTO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 1:44 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface EmployeeService {

    PageResultDTO<EmployeeDTO> findEmployeeByQuery(EmployeeQueryDTO employeeQueryDTO);

}
