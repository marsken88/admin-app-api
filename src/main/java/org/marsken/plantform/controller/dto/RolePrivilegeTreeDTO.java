package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 6:03 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class RolePrivilegeTreeDTO {

    private Long roleId;

    private List<RolePrivilegeSimpleDTO> privileges;

    private List<String> selectedKey;
}
