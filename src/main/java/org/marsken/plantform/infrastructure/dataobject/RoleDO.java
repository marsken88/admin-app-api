package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 3:57 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class RoleDO {
    private Long id;

    private String roleName;

    private String remark;

    private Date updateTime;

    private Date createTime;
}
