package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 1:59 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface PrivilegeMapper {

    List<PrivilegeDO> findAll();

    List<PrivilegeDO> findByType(Integer type);
}
