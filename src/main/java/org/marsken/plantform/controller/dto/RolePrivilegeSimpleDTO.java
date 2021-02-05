package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 6:05 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class RolePrivilegeSimpleDTO {

    private String parentKey;

    private String name;

    private Integer type;

    private String key;

    private String url;

    private Integer sort;

    private List<RolePrivilegeSimpleDTO> children;

}
