package org.marsken.plantform.controller;

import io.swagger.annotations.ApiOperation;
import org.marsken.arch.core.clientobject.PageResultDTO;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/29 3:19 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class NoticeController {

    @ApiOperation(value = "分页查询未读消息")
    @PostMapping("/notice/unread/page/query")
    public ResponseDTO<PageResultDTO> queryUnreadByPage() {
        PageResultDTO pageResultDTO = new PageResultDTO();
        pageResultDTO.setPageNum(1L);
        pageResultDTO.setPageSize(20L);
        pageResultDTO.setTotal(0L);
        pageResultDTO.setPages(0L);
        pageResultDTO.setList(new ArrayList());
        return ResponseDTO.builderSuccess(pageResultDTO);
    }

}
