package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.RoleAddDTO;
import org.marsken.plantform.controller.dto.RoleDTO;
import org.marsken.plantform.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 3:49 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class RoleController {

    @GetMapping(value = "/role/getAll")
    public ResponseDTO<List<RoleDTO>> findAllRole() {
        return ResponseDTO.builderSuccess(roleService.findAllRole());
    }

    @PostMapping(value = "/role/add")
    public ResponseDTO<Boolean> save(@RequestBody RoleAddDTO roleAddDTO) {
        return ResponseDTO.builderSuccess(roleService.save(roleAddDTO));
    }

    @GetMapping(value = "/role/get/{roleId}")
    public ResponseDTO<RoleDTO> findRoleById(@PathVariable Long roleId) {
        return ResponseDTO.builderSuccess(roleService.findById(roleId));
    }

    @Autowired
    private RoleService roleService;
}
