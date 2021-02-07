package org.marsken.plantform.controller;

import com.github.pagehelper.PageInfo;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.RoleQueryDTO;
import org.marsken.plantform.domain.service.RoleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 2:06 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class RoleEmployeeController {

    @PostMapping(value = "/role/listEmployee")
    public ResponseDTO<PageInfo<EmployeeDTO>> findEmployeeListByName(@RequestBody RoleQueryDTO roleQueryDTO) {
        return ResponseDTO.builderSuccess(roleEmployeeService.findEmployeeByNamePage(roleQueryDTO));

    }

    @Autowired
    private RoleEmployeeService roleEmployeeService;
}
