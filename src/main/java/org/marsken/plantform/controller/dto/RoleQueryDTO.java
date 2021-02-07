package org.marsken.plantform.controller.dto;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 2:08 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class RoleQueryDTO extends QueryPageDTO{
    private Long roleId;

    private String roleName;
}
