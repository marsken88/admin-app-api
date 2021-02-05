package org.marsken.plantform.domain.service;

import com.github.pagehelper.PageInfo;
import org.marsken.plantform.controller.dto.NoticeAddDTO;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 2:32 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface NoticeService {

    PageInfo<NoticeDTO> findUnReadByPage(NoticeQueryDTO noticeQueryDTO);

    PageInfo<NoticeDTO> findNoticeByPage(NoticeQueryDTO noticeQueryDTO);

    NoticeDTO findById(Long id);

    NoticeDTO readById(Long id);

    Boolean deleteById(Long id);

    Boolean sendById(Long id);

    Boolean save(NoticeAddDTO noticeAddDTO);
}
