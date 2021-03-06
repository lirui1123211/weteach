package com.legend.cloud.campus.service.system.impl;

import com.legend.cloud.campus.dao.mapper.system.SystemRoleMapper;
import com.legend.cloud.campus.model.pojo.entity.system.SystemRole;
import com.legend.cloud.campus.model.pojo.entity.system.example.SystemRoleExample;
import com.legend.cloud.campus.service.system.SystemRoleService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemRoleServiceImpl extends AbstractLegendService<SystemRole> implements SystemRoleService {

    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Override
    public Mapper<SystemRole> getMapper() {
        return systemRoleMapper;
    }

    @Override
    protected Object getExample(SystemRole systemRole, String order, String sort) {
        SystemRoleExample example = new SystemRoleExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        SystemRoleExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (systemRole == null) {
            return example;
        }

        if (systemRole.getId() != null) {
            criteria.andIdEqualTo(systemRole.getId());
        }
        if (systemRole.getRoleName() != null) {
            criteria.andRoleNameEqualTo(systemRole.getRoleName());
        }
        if (systemRole.getSign() != null) {
            criteria.andSignEqualTo(systemRole.getSign());
        }
        if (systemRole.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(systemRole.getCreateTime());
        }
        if (systemRole.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(systemRole.getUpdateTime());
        }
        if (systemRole.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(systemRole.getIsDeleted());
        }
        return example;
    }

    @Override
    public List<SystemRole> getListByIds(List<Integer> ids) {
        if (ids == null) {
            throw new NullPointerException();
        }
        SystemRoleExample example = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        criteria.andIdIn(ids);
        return getListByExample(example);
    }
}
