package com.legend.cloud.campus.facade.impl;

import com.legend.cloud.campus.facade.CampusUserFacade;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUser;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.cloud.campus.service.base.BaseUserService;
import com.legend.cloud.campus.service.campus.CampusAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2018/4/11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusUserFacadeImpl implements CampusUserFacade {

    @Resource
    private BaseUserService baseUserService;

    @Resource
    private CampusAccountService campusAccountService;


    @Override
    public int updateUser(BaseUser baseUser, CampusAccount campusAccount) {
        if (baseUser == null || campusAccount == null) {
            throw new NullPointerException();
        }
        if (campusAccountService.updateById(campusAccount) <= 0) {
            return 0;
        }
        if (baseUserService.updateById(baseUser) <= 0) {
            return 0;
        }
        return 1;
    }
}
