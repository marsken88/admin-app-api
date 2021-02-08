package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.DepartmentAddDTO;
import org.marsken.plantform.controller.dto.DepartmentDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface DepartmentService {

    List<DepartmentDTO> findAll();

    List<DepartmentDTO> findEmployeeByDepartmentName(String departmentName);

    Boolean delDepartment(Long departmentId);

    Boolean upOrDown(Long departmentId, Long swapId);

    Boolean upgrade(Long departmentId);

    Boolean downgrade(Long departmentId, Long preId);

    Boolean save(DepartmentAddDTO departmentAddDTO);
}
