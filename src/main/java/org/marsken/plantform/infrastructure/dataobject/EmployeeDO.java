package org.marsken.plantform.infrastructure.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 1:27 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeDO {
    private Long id;

    private String loginName;

    private String loginPwd;

    private String actualName;

    private String nickName;

    private String phone;

    private String idCard;

    private Date birthday;

    private String email;

    private Long departmentId;

    private Integer isLeave;

    private Integer isDisabled;

    private String remark;

    private Long createUser;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;
}
