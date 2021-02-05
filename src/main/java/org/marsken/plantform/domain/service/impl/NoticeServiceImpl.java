package org.marsken.plantform.domain.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;
import org.marsken.plantform.domain.service.NoticeService;
import org.marsken.plantform.infrastructure.dataobject.NoticeDO;
import org.marsken.plantform.infrastructure.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PageInfo<NoticeDTO> findNoticeByPage(NoticeQueryDTO noticeQueryDTO) {
        Page page = PageHelper.startPage(noticeQueryDTO.getPageNum(), noticeQueryDTO.getPageSize());
        List<NoticeDO> noticeDOList = noticeMapper.findByPage(noticeQueryDTO);
        List<NoticeDTO> noticeDTOList = new ArrayList<>();
        for (NoticeDO noticeDO : noticeDOList) {
            NoticeDTO noticeDTO = new NoticeDTO();
            noticeDTO.setId(noticeDO.getId());
            noticeDTO.setTitle(noticeDO.getTitle());
//            noticeDTO.setCreateUserName(noticeDO.getCreatUser());
            noticeDTO.setSendStatus(noticeDO.getSendStatus());
//            noticeDTO.setCreateTime(noticeDO.get());
            noticeDTOList.add(noticeDTO);
        }
        PageInfo pageInfo = new PageInfo(page.getResult());
        pageInfo.setList(noticeDTOList);
        return pageInfo;
    }

    @Autowired
    private NoticeMapper noticeMapper;
}
