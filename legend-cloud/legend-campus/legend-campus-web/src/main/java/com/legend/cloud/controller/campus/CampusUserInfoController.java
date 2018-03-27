package com.legend.cloud.controller.campus;


import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.service.campus.CampusUserInfoService;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import com.legend.module.core.web.controller.LegendController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/userInfo")
public class CampusUserInfoController extends LegendController {

    @Resource
    private CampusUserInfoService campusUserInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("campus:userInfo:list")
    public Ajax list(CampusUserInfoVO campusUserInfoVO, Query query) {
        try {
            List<CampusUserInfo> campusUserInfoList = campusUserInfoService.getList(campusUserInfoVO.parseTo(),
                    query);
            List<CampusUserInfoVO> campusUserInfoVOList = campusUserInfoList.stream().map((entity) ->
                    new CampusUserInfoVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusUserInfoVOList, campusUserInfoVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusUserInfoVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("campus:userInfo:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusUserInfo campusUserInfo =campusUserInfoService.getById(id);
                CampusUserInfoVO campusUserInfoVO = new CampusUserInfoVO().parseFrom(campusUserInfo);
            return Ajax.success(campusUserInfoVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("campus:userInfo:add")
    public Ajax add(@Validated CampusUserInfoVO campusUserInfoVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = campusUserInfoService.save(campusUserInfoVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("campus:userInfo:update")
    public Ajax update(@Validated CampusUserInfoVO campusUserInfoVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = campusUserInfoService.updateById(campusUserInfoVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("campus:userInfo:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusUserInfoService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}