package org.marsken.plantform.infrastructure.mapper;

import org.marsken.plantform.controller.dto.DepartmentDTO;
import org.marsken.plantform.infrastructure.dataobject.DepartmentDO;
import org.marsken.plantform.infrastructure.dataobject.RoleDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:01 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface DepartmentMapper {

    List<DepartmentDO> findAll();

    List<DepartmentDO> findByName(String name);

    DepartmentDO findById(Long id);

    Integer deleteById(Long id);

    Integer updateSortById(Integer sort, Long id);

    Integer updateParentIdById(Long parentId, Long id);

    Long save(DepartmentDO departmentDO);
}
