package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/10 2:05 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeUpdateRolesDTO {
    private Long employeeId;

    private List<Long> roleIds;
}
