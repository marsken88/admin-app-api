package org.marsken.plantform.controller.dto;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:49 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class DepartmentAddDTO {
    private String name;

    private Long parentId;

    private Long type;
}
