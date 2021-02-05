package org.marsken.plantform.infrastructure.mapper;

import com.github.pagehelper.Page;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;
import org.marsken.plantform.infrastructure.dataobject.NoticeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 4:01 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface NoticeMapper {

    List<NoticeDO> findByPage(NoticeQueryDTO noticeQueryDTO);

    NoticeDO findById(Long id);
}
