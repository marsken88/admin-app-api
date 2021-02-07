package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.infrastructure.dataobject.RoleDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:01 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface RoleMapper {

    List<RoleDO> findAll();

    Boolean save(RoleDO roleDO);
}
