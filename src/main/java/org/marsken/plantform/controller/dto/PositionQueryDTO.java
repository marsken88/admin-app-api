package org.marsken.plantform.controller.dto;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 11:59 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PositionQueryDTO extends QueryPageDTO {

    private String positionName;

    private Boolean searchCount;

    private Boolean sort;
}
