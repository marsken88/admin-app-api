package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.controller.dto.PositionQueryDTO;
import org.marsken.plantform.infrastructure.dataobject.PositionDO;
import org.marsken.plantform.infrastructure.dataobject.PrivilegeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/1 1:59 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface PositionMapper {

    List<PositionDO> findByQueryPage(PositionQueryDTO positionQueryDTO);

    Integer updatePostionNameAndRemarkById(String positionName, String remark, Long id);

    Integer save(PositionDO positionDO);

    Integer remove(Long id);

}
