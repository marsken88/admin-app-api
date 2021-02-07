package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.DepartmentDTO;
import org.marsken.plantform.domain.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:49 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class DepartmentController {

    @GetMapping("/department/listEmployee")
    public ResponseDTO<List<DepartmentDTO>> listDepartmentEmployee() {
        return ResponseDTO.builderSuccess(departmentService.findAll());
    }

    @Autowired
    private DepartmentService departmentService;
}
