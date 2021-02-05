package org.marsken.plantform.domain.service;

import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 2:32 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface NoticeService {

    PageInfo<NoticeDTO> findNoticeByPage(NoticeQueryDTO noticeQueryDTO);

    NoticeDTO findById(Long id);
}
