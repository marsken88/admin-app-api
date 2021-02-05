package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.domain.service.RolePrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 5:24 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class RolePrivilegeController {

    @GetMapping("/privilege/listPrivilegeByRoleId/{roleId}")
    public ResponseDTO listPrivilegeByRoleId(@PathVariable Long roleId) {
        return ResponseDTO.builderSuccess(null);
    }

    @Autowired
    private RolePrivilegeService rolePrivilegeService;
}
