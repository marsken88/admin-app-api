package org.marsken.plantform.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.marsken.arch.core.clientobject.PageResultDTO;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.NoticeDTO;
import org.marsken.plantform.controller.dto.NoticeQueryDTO;
import org.marsken.plantform.domain.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    public ResponseDTO<PageInfo<NoticeDTO>> queryUnreadByPage(@RequestBody NoticeQueryDTO noticeQueryDTO) {
        return ResponseDTO.builderSuccess(noticeService.findUnReadByPage(noticeQueryDTO));
    }

    @PostMapping(value = "/notice/page/query")
    public ResponseDTO<PageInfo<NoticeDTO>> findByPage(@RequestBody NoticeQueryDTO noticeQueryDTO) {
        return ResponseDTO.builderSuccess(noticeService.findNoticeByPage(noticeQueryDTO));
    }

    @GetMapping(value = "/notice/detail/{id}")
    public ResponseDTO<NoticeDTO> findById(@PathVariable Long id) {
        return ResponseDTO.builderSuccess(noticeService.findById(id));
    }

    @GetMapping(value = "/notice/read/{id}")
    public ResponseDTO<NoticeDTO> readById(@PathVariable Long id) {
        return ResponseDTO.builderSuccess(noticeService.readById(id));
    }

    @GetMapping(value = "/notice/delete/{id}")
    public ResponseDTO<Boolean> deleteById(@PathVariable Long id) {
        return ResponseDTO.builderSuccess(noticeService.deleteById(id));
    }

    @Autowired
    private NoticeService noticeService;
}
