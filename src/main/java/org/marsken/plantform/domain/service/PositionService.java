package org.marsken.plantform.domain.service;

import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.PositionAddDTO;
import org.marsken.plantform.controller.dto.PositionDTO;
import org.marsken.plantform.controller.dto.PositionQueryDTO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 12:06 上午
 * @description：
 * @modified By：
 * @version: $
 */
public interface PositionService {
    PageInfo<PositionDTO> findByQueryPage(PositionQueryDTO positionQueryDTO);

    Boolean updatePostionNameAndRemarkById(PositionAddDTO positionAddDTO);

    Boolean save(PositionAddDTO positionAddDTO);

    Boolean remove(Long id);
}
