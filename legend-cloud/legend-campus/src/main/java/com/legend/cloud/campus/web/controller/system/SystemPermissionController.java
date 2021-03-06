package com.legend.cloud.campus.web.controller.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemPermission;
import com.legend.cloud.campus.model.pojo.vo.system.SystemPermissionVO;
import com.legend.cloud.campus.service.system.SystemPermissionService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/system/permission")
public class SystemPermissionController extends CampusController {

    @Resource
    private SystemPermissionService systemPermissionService;

    @GetMapping(value = "/list")
    // @RequiresPermissions("permission:permission:list")
    public Ajax list(SystemPermissionVO systemPermissionVO, QueryUtils query) {
        try {
            List<SystemPermission> systemPermissionList = systemPermissionService.getList(systemPermissionVO.parseTo(),
                    query);
            List<SystemPermissionVO> systemPermissionVOList = new SystemPermissionVO().parseFrom(systemPermissionList);
            PageUtils pageUtils = new PageUtils(systemPermissionVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemPermissionVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping(value = "/details/{id}")
    // @RequiresPermissions("permission:permission:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemPermission systemPermission = systemPermissionService.getById(id);
            SystemPermissionVO systemPermissionVO = new SystemPermissionVO().parseFrom(systemPermission);
            return Ajax.success(systemPermissionVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping(value = "/add")
    // @RequiresPermissions("permission:permission:add")
    public Ajax add(@Validated(AddGroup.class) SystemPermissionVO systemPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = systemPermissionService.save(systemPermissionVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update")
    // @RequiresPermissions("permission:permission:update")
    public Ajax update(@Validated(UpdateGroup.class) SystemPermissionVO systemPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = systemPermissionService.updateById(systemPermissionVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    // @RequiresPermissions("permission:permission:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemPermissionService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
