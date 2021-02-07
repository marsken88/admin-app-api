package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.DepartmentDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface DepartmentService {

    List<DepartmentDTO> findAll();
}
