package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 1:58 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class PrivilegeDO {
    /**
     * 功能权限类型：1.模块 2.页面 3.功能点 4.子模块
     */
    private Integer type;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 路由name 英文关键字
     */
    private String key;


    private String url;

    /**
     * 排序
     */
    private Integer sort;


    /**
     * 父级key
     */
    private String parentKey;
}
