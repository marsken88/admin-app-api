package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 10:55 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PositionRelationAddDTO {
    private List<Long> positionIdList;

    private Long employeeId;
}
