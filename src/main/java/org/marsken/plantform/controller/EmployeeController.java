package org.marsken.plantform.controller;

import com.github.pagehelper.PageInfo;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.controller.dto.EmployeeQueryDTO;
import org.marsken.plantform.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 11:25 上午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class EmployeeController {

    @PostMapping(value = "/employee/query")
    public ResponseDTO<PageInfo<EmployeeDTO>> query(@RequestBody EmployeeQueryDTO employeeQueryDTO) {
        return ResponseDTO.builderSuccess(employeeService.findEmployeeByQuery(employeeQueryDTO));
    }


    @Autowired
    private EmployeeService employeeService;
}
