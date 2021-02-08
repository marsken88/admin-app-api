package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.infrastructure.dataobject.PositionRelationDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 10:41 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface PositionRelationMapper {

    Long save(PositionRelationDO positionRelationDO);

    Long saveBatch(List<PositionRelationDO> positionRelationDOList);
}
