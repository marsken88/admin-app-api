package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 12:00 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PositionDTO {
    private Long id;

    private String positionName;

    private String remark;

    private Date updateTime;

    private Date createTime;
}
