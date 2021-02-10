package org.marsken.plantform.domain.service;

import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.EmployeeAddDTO;
import org.marsken.plantform.controller.dto.EmployeeBatchUpdateStatusDTO;
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

    PageInfo<EmployeeDTO> findEmployeeByQuery(EmployeeQueryDTO employeeQueryDTO);

    Boolean save(EmployeeAddDTO employeeAddDTO);

    Boolean batchUpdateStatus(EmployeeBatchUpdateStatusDTO employeeBatchUpdateStatusDTO);

    Boolean updateStatus(Long employeeId, Integer status);
}
