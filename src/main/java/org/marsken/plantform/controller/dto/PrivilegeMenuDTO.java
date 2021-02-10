package org.marsken.plantform.controller.dto;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 2:55 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PrivilegeMenuDTO {
    private String menuName;

    private String menuKey;

    private String parentKey;

    private Integer sort;

    private String url;

}
