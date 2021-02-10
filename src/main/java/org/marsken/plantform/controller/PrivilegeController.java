package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.PrivilegeMenuDTO;
import org.marsken.plantform.controller.dto.PrivilegeUrlDTO;
import org.marsken.plantform.domain.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 2:28 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class PrivilegeController {

    @GetMapping(value = "/privilege/getAllUrl")
    public ResponseDTO<List<PrivilegeUrlDTO>> findAllUrl() {
        return ResponseDTO.builderSuccess(privilegeService.findAll());
    }

    @PostMapping("/privilege/menu/queryAll")
    private ResponseDTO<List<PrivilegeMenuDTO>> queryAll() {
        return ResponseDTO.builderSuccess(privilegeService.findMenuByType());
    }


    @Autowired
    private PrivilegeService privilegeService;
}
