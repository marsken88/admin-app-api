package org.marsken.plantform.infrastructure.dataobject;


import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 12:01 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PositionDO {
    private Long id;

    private String positionName;

    private String remark;

    private Date updateTime;

    private Date createTime;
}
