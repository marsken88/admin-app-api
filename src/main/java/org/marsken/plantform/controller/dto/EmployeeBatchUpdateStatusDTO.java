package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/9 7:44 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeBatchUpdateStatusDTO {
    private Integer status;

    private List<Long> employeeIds;
}
