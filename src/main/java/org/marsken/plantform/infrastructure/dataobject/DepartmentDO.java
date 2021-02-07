package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:52 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class DepartmentDO {

    private Long id;

    private String name;

    private String shortName;

    private Long managerId;

    private Long parentId;

    private Integer sort;

    private Date updateTime;

    private Date createTime;



}
