package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.controller.dto.PositionRelationAddDTO;
import org.marsken.plantform.domain.service.PositionRelationService;
import org.marsken.plantform.infrastructure.dataobject.PositionRelationDO;
import org.marsken.plantform.infrastructure.mapper.PositionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 10:52 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class PositionRelationServiceImpl implements PositionRelationService {

    @Override
    public Boolean savePositionRelation(PositionRelationAddDTO positionRelationAddDTO) {
        List<PositionRelationDO> positionRelationDOList = new ArrayList<>();
        Date now = new Date();
        positionRelationAddDTO.getPositionIdList().forEach(positionId->{
            PositionRelationDO positionRelationDO = new PositionRelationDO();
            positionRelationDO.setPositionId(positionId);
            positionRelationDO.setEmployeeId(positionRelationAddDTO.getEmployeeId());
            positionRelationDO.setCreateTime(now);
            positionRelationDO.setUpdateTime(now);
            positionRelationDOList.add(positionRelationDO);
        });
        positionRelationMapper.saveBatch(positionRelationDOList);
        return Boolean.TRUE;
    }

    @Autowired
    private PositionRelationMapper positionRelationMapper;
}
