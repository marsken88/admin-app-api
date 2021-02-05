package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.NoticeAddDTO;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;
import org.marsken.plantform.convertor.NoticeConvertor;
import org.marsken.plantform.domain.constant.JudgeEnum;
import org.marsken.plantform.domain.service.NoticeService;
import org.marsken.plantform.infrastructure.dataobject.NoticeDO;
import org.marsken.plantform.infrastructure.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 2:32 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Override
    public PageInfo<NoticeDTO> findUnReadByPage(NoticeQueryDTO noticeQueryDTO) {
        Page page = PageHelper.startPage(noticeQueryDTO.getPageNum(), noticeQueryDTO.getPageSize());
        List<NoticeDO> noticeDOList = noticeMapper.findUnReadByPage();
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(noticeConvertor.toDTOList(noticeDOList));
        return pageInfo;
    }

    @Override
    public PageInfo<NoticeDTO> findNoticeByPage(NoticeQueryDTO noticeQueryDTO) {
        Page page = PageHelper.startPage(noticeQueryDTO.getPageNum(), noticeQueryDTO.getPageSize());
        List<NoticeDO> noticeDOList = noticeMapper.findByPage(noticeQueryDTO);
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(noticeConvertor.toDTOList(noticeDOList));
        return pageInfo;
    }

    @Override
    public NoticeDTO findById(Long id) {
        NoticeDO noticeDO = noticeMapper.findById(id);
        return noticeConvertor.toDTO(noticeDO);
    }

    @Override
    public NoticeDTO readById(Long id) {
        NoticeDO noticeDO = noticeMapper.findById(id);
        return noticeConvertor.toDTO(noticeDO);
    }

    @Override
    public Boolean deleteById(Long id) {
        noticeMapper.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean sendById(Long id) {
        return Boolean.TRUE;
    }

    @Override
    public Boolean save(NoticeAddDTO noticeAddDTO) {
        NoticeDO noticeDO = new NoticeDO();
        noticeDO.setContent(noticeAddDTO.getContent());
        noticeDO.setTitle(noticeAddDTO.getTitle());
        noticeDO.setDeleted(JudgeEnum.NO.getValue());
        noticeDO.setSendStatus(JudgeEnum.NO.getValue());
        noticeDO.setCreateTime(new Date());
        noticeDO.setUpdateTime(new Date());
        noticeDO.setCreatUser(1L);
        noticeMapper.save(noticeDO);
        return Boolean.TRUE;
    }

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeConvertor noticeConvertor;
}
