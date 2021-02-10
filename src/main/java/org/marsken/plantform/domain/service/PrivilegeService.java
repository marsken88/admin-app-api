package org.marsken.plantform.domain.service;

import org.marsken.plantform.controller.dto.PrivilegeMenuDTO;
import org.marsken.plantform.controller.dto.PrivilegeUrlDTO;

import java.util.List;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/4 3:08 下午
 * @description：
 * @modified By：
 * @version: $
 */
public interface PrivilegeService {

    List<PrivilegeUrlDTO> findAll();

    List<PrivilegeMenuDTO> findMenuByType();
}
