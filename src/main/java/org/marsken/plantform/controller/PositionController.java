package org.marsken.plantform.controller;

import com.github.pagehelper.PageInfo;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.PositionAddDTO;
import org.marsken.plantform.controller.dto.PositionDTO;
import org.marsken.plantform.controller.dto.PositionQueryDTO;
import org.marsken.plantform.domain.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/8 12:07 上午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class PositionController {

    @PostMapping(value = "/position/getListPage")
    public ResponseDTO<PageInfo<PositionDTO>> findByQueryPage(@RequestBody PositionQueryDTO positionQueryDTO) {
        return ResponseDTO.builderSuccess(positionService.findByQueryPage(positionQueryDTO));
    }

    @PostMapping(value = "/position/update")
    public ResponseDTO<Boolean> update(@RequestBody PositionAddDTO positionAddDTO) {
        return ResponseDTO.builderSuccess(positionService.updatePostionNameAndRemarkById(positionAddDTO));
    }

    @PostMapping(value = "/position/add")
    public ResponseDTO<Boolean> save(@RequestBody PositionAddDTO positionAddDTO) {
        return ResponseDTO.builderSuccess(positionService.save(positionAddDTO));
    }

    @GetMapping(value = "/position/remove/{id}")
    public ResponseDTO<Boolean> remove(@PathVariable Long id) {
        return ResponseDTO.builderSuccess(positionService.remove(id));
    }

    @Autowired
    private PositionService positionService;
}
