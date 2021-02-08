package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 10:39 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PositionRelationDO {
    private Long id;

    private Long positionId;

    private Long employeeId;

    private Date updateTime;

    private Date createTime;
}
