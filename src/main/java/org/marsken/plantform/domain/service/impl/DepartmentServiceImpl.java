package org.marsken.plantform.domain.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.marsken.plantform.controller.dto.DepartmentDTO;
import org.marsken.plantform.controller.dto.EmployeeDTO;
import org.marsken.plantform.convertor.DepartmentConvertor;
import org.marsken.plantform.convertor.EmployeeConvertor;
import org.marsken.plantform.domain.service.DepartmentService;
import org.marsken.plantform.infrastructure.dataobject.DepartmentDO;
import org.marsken.plantform.infrastructure.dataobject.EmployeeDO;
import org.marsken.plantform.infrastructure.mapper.DepartmentMapper;
import org.marsken.plantform.infrastructure.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/2/7 1:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<DepartmentDTO> findAll() {
        List<DepartmentDO> departmentDOList = departmentMapper.findAll();
        return departmentConvertor.toDTOList(departmentDOList);
    }

    @Override
    public List<DepartmentDTO> findEmployeeByDepartmentName(String departmentName) {
        List<DepartmentDO> departmentDOList = new ArrayList<>();
        if (StringUtils.isEmpty(departmentName)) {
            departmentDOList = departmentMapper.findAll();
        } else {
            departmentDOList = departmentMapper.findByName(departmentName);
        }
        List<EmployeeDO> employeeDOList = employeeMapper.findAll();
        List<DepartmentDTO> departmentDTOList = departmentConvertor.toDTOList(departmentDOList);
        Map<Long, DepartmentDTO> departmentDTOMap = departmentDTOList.stream()
                .collect(Collectors.toMap(DepartmentDTO::getId, Function.identity()));
        employeeDOList.forEach(employeeDO -> {
            DepartmentDTO departmentDTO = departmentDTOMap.get(employeeDO.getDepartmentId());
            if (Objects.nonNull(departmentDTO)) {
                if (CollectionUtils.isEmpty(departmentDTO.getEmployees())) {
                    departmentDTO.setEmployees(new ArrayList<>());
                }
                List<EmployeeDTO> employeeDTOList = departmentDTO.getEmployees();
                employeeDTOList.add(employeeConvertor.toDTO(employeeDO));
                departmentDTO.setEmployees(employeeDTOList);
            }

        });
        return buildTree(departmentDTOList);
    }

    @Override
    public Boolean delDepartment(Long departmentId) {
        departmentMapper.deleteById(departmentId);
        return Boolean.TRUE;
    }

    @Transactional
    @Override
    public Boolean upOrDown(Long departmentId, Long swapId) {
        DepartmentDO departmentDO = departmentMapper.findById(departmentId);
        DepartmentDO swapDepartmentDO = departmentMapper.findById(swapId);
        if (Objects.nonNull(departmentDO) && Objects.nonNull(swapDepartmentDO)) {
            departmentMapper.updateSortById(swapDepartmentDO.getSort(), departmentId);
            departmentMapper.updateSortById(departmentDO.getSort(), swapId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean upgrade(Long departmentId) {
        DepartmentDO departmentDO = departmentMapper.findById(departmentId);
        if (Objects.nonNull(departmentDO) && Objects.nonNull(departmentDO.getParentId())) {
            DepartmentDO parentDepartmentDO = departmentMapper.findById(departmentDO.getParentId());
            departmentMapper.updateParentIdById(parentDepartmentDO.getParentId(), departmentId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean downgrade(Long departmentId, Long preId) {
        DepartmentDO departmentDO = departmentMapper.findById(departmentId);
        DepartmentDO preDepartmentDO = departmentMapper.findById(preId);
        if (Objects.nonNull(departmentDO) && Objects.nonNull(preDepartmentDO)) {
            departmentMapper.updateParentIdById(preId, departmentId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    private List<DepartmentDTO> buildTree(List<DepartmentDTO> departmentDTOList) {
        List<DepartmentDTO> rootDepartment = departmentDTOList.stream()
                .filter(departmentDTO -> Objects.isNull(departmentDTO.getParentId()) || departmentDTO.getParentId() == 0)
                .collect(Collectors.toList());
        buildTree(rootDepartment, departmentDTOList);
        return rootDepartment;
    }

    private void buildTree(List<DepartmentDTO> nodeList, List<DepartmentDTO> departmentDTOList) {
        int nodeSize = nodeList.size();
        for (int i = 0; i < nodeSize; i++) {
            int preIndex = i - 1;
            int nextIndex = i + 1;
            DepartmentDTO node = nodeList.get(i);
            if (preIndex > -1) {
                node.setPreId(nodeList.get(preIndex).getId());
            }
            if (nextIndex < nodeSize) {
                node.setNextId(nodeList.get(nextIndex).getId());
            }
            buildTree(node, departmentDTOList);
        }
    }

    private void buildTree(DepartmentDTO root, List<DepartmentDTO> departmentDTOList) {
        List<DepartmentDTO> child = findChild(root, departmentDTOList);
        if (CollectionUtils.isNotEmpty(child)) {
            root.setChildren(child);
            buildTree(child, departmentDTOList);
        }
    }

    private List<DepartmentDTO> findChild(DepartmentDTO departmentDTO, List<DepartmentDTO> departmentDTOList) {
        return departmentDTOList.stream().filter(department -> departmentDTO.getId().equals(department.getParentId()))
                .collect(Collectors.toList());
    }


    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentConvertor departmentConvertor;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeConvertor employeeConvertor;
}
