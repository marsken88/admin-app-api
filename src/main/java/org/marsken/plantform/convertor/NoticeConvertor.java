package org.marsken.plantform.convertor;

import org.mapstruct.Mapper;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.infrastructure.dataobject.NoticeDO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/5 11:45 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface NoticeConvertor {

    NoticeDTO toDTO(NoticeDO noticeDO);

    List<NoticeDTO> toDTOList(List<NoticeDO> noticeDO);
}
