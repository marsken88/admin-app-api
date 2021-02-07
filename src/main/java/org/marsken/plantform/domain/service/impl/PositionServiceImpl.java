package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.PositionAddDTO;
import org.marsken.plantform.controller.dto.PositionDTO;
import org.marsken.plantform.controller.dto.PositionQueryDTO;
import org.marsken.plantform.convertor.PositionConvertor;
import org.marsken.plantform.domain.service.PositionService;
import org.marsken.plantform.infrastructure.dataobject.PositionDO;
import org.marsken.plantform.infrastructure.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 12:06 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Override
    public PageInfo<PositionDTO> findByQueryPage(PositionQueryDTO positionQueryDTO) {
        Page page = PageHelper.startPage(positionQueryDTO.getPageNum(), positionQueryDTO.getPageSize());
        List<PositionDO> positionDOList = positionMapper.findByQueryPage(positionQueryDTO);
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(positionConvertor.toDTOList(positionDOList));
        return pageInfo;
    }

    @Override
    public Boolean updatePostionNameAndRemarkById(PositionAddDTO positionAddDTO) {
        positionMapper.updatePostionNameAndRemarkById(positionAddDTO.getPositionName(), positionAddDTO.getRemark(), positionAddDTO.getId());
        return Boolean.TRUE;
    }

    @Override
    public Boolean save(PositionAddDTO positionAddDTO) {
        PositionDO positionDO = new PositionDO();
        positionDO.setPositionName(positionAddDTO.getPositionName());
        positionDO.setRemark(positionAddDTO.getRemark());
        Date now = new Date();
        positionDO.setCreateTime(now);
        positionDO.setUpdateTime(now);
        positionMapper.save(positionDO);
        return Boolean.TRUE;
    }

    @Override
    public Boolean remove(Long id) {
        positionMapper.remove(id);
        return Boolean.TRUE;
    }

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private PositionConvertor positionConvertor;
}
