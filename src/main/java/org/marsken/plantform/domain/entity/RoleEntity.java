package org.marsken.plantform.domain.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 11:27 下午
 * @description：权限实体类
 * @modified By：
 * @version: 1.0.0$
 */
@Data
public class RoleEntity implements GrantedAuthority {
    private Long id;
    private String name;


    @Override
    public String getAuthority() {
        return name;
    }
}
