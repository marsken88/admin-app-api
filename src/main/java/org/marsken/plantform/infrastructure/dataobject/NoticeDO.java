package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 2:11 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class NoticeDO {
    private Long id;

    private String title;

    private String content;

    private Long creatUser;

    private Integer sendStatus;

    private Integer deleted;

}
