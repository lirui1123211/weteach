package com.legend.cloud.campus.web.controller.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseFile;
import com.legend.cloud.campus.model.pojo.vo.base.BaseFileVO;
import com.legend.cloud.campus.service.base.BaseFileService;
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
@RequestMapping("/base/file")
public class BaseFileController extends CampusController {

    @Resource
    private BaseFileService baseFileService;

    @GetMapping("/list")
    // @RequiresPermissions("base:file:list")
    public Ajax list(BaseFileVO baseFileVO, QueryUtils query) {
        try {
            List<BaseFile> baseFileList = baseFileService.getList(baseFileVO.parseTo(),
                    query);
            List<BaseFileVO> baseFileVOList = new BaseFileVO().parseFrom(baseFileList);
            PageUtils pageUtils = new PageUtils(baseFileVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseFileVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("base:file:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseFile baseFile = baseFileService.getById(id);
            BaseFileVO baseFileVO = new BaseFileVO().parseFrom(baseFile);
            return Ajax.success(baseFileVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("base:file:add")
    public Ajax add(@Validated(AddGroup.class) BaseFileVO baseFileVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseFileService.save(baseFileVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("base:file:update")
    public Ajax update(@Validated(UpdateGroup.class) BaseFileVO baseFileVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseFileService.updateById(baseFileVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("base:file:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseFileService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
