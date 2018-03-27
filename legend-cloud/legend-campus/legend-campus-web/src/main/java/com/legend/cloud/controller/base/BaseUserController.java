package com.legend.cloud.controller.base;


import com.legend.cloud.entity.system.SystemUser;
import com.legend.cloud.vo.system.SystemUserVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.service.user.UserService;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import com.legend.module.core.web.controller.LegendController;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.vo.base.BaseUserVO;
import com.legend.module.core.web.controller.user.AbstractUserController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/base/user")
public class BaseUserController extends AbstractUserController<BaseUserVO> {

    @Resource
    private BaseUserService baseUserService;

    @Resource
    private SecurityManager securityManager;


    @Override
    public UserService getUserService() {
        return baseUserService;
    }

    @Override
    protected boolean loginPreProcess(BaseUserVO baseUserVO) {
        return false;
    }

    @Override
    protected Ajax loginProcess(BaseUserVO baseUserVO) {
        UsernamePasswordToken token = new UsernamePasswordToken(baseUserVO.getUsername(), baseUserVO.getPassword
                (), baseUserVO.isRememberMe(), "base");
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            BaseUser currentUser = (BaseUser) subject.getPrincipal();
            // 更新最后登录时间
            currentUser.setLastLoginTime(new Date());
            baseUserService.updateById(currentUser);
            // 设置用户到session
            setCurrentUser(new BaseUserVO().parseFrom(currentUser, "password",
                    "last_login_time", "create_time", "update_time"));
            return Ajax.success(UserResultMessage.LOGIN_SUCCESS).put(Key.URL, "/direct/index");
        } catch (IncorrectCredentialsException e) {
            System.err.println(e.getLocalizedMessage());
            return Ajax.error(UserResultMessage.USERNAME_OR_PASSWORD_WRONG);
        } catch (AuthenticationException e) {
            System.err.println(e.getLocalizedMessage());
            return Ajax.error(UserResultMessage.USERNAME_WRONG);
        }
    }

    @Override
    protected boolean logoutPreProcess(BaseUserVO baseUserVO) {
        return false;
    }

    @Override
    protected Ajax logoutProcess(BaseUserVO baseUserVO) {
        return Ajax.error();
    }
}
