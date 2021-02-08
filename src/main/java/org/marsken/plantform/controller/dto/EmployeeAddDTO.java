package org.marsken.plantform.controller.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/2 1:41 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class EmployeeAddDTO {

    private String actualName;

    private String loginName;

    private String nickName;

    private Long departmentId;

    private Integer isDisabled;

    private String phone;

    private String idCard;

    private String birthday;

    private String loginPwd;

    private String email;

    private List<Long> positionIdList;
}
