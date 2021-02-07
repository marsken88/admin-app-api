package org.marsken.plantform.domain.service;

import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.RoleQueryDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 2:09 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface RoleEmployeeService {

    PageInfo<EmployeeDTO> findEmployeeByNamePage(RoleQueryDTO roleQueryDTO);


    List<EmployeeDTO> findEmployeeByRoleId(Long roleId);
}
