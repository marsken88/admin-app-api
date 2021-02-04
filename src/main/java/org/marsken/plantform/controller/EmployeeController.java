package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.PageResultDTO;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseDTO<PageResultDTO<EmployeeDTO>> query(){
        return ResponseDTO.builderSuccess(null);
    }


}
