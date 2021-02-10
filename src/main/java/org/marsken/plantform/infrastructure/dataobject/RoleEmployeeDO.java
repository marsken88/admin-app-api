package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 2:10 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class RoleEmployeeDO {

    private Long id;

    private Long employeeId;

    private Long roleId;

    private Date createTime;

    private Date updateTime;
}
