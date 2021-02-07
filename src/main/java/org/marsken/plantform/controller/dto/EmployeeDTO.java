package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 1:41 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeDTO {

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

    private Data updateTime;

    private Integer isDelete;

}
