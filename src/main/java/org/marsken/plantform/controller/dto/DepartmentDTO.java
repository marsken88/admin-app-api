package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:49 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class DepartmentDTO {

    private Long id;

    private String name;

    private String shortName;

    private Long managerId;

    private Long parentId;

    private Integer sort;

    private Date updateTime;

    private Date createTime;

    private List<EmployeeDTO> employees;

    private List<DepartmentDTO> children;

    private Long preId;

    private Long nextId;
}
