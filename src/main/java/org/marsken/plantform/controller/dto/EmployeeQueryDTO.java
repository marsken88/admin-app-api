package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 2:32 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeQueryDTO extends QueryPageDTO {
    private String phone;

    private String actualName;

    private String keyword;

    private Long departmentId;

    private Integer isLeave;

    private Integer isDisabled;

    private Integer isDelete;

    private List<Long> employeeIds;

}
