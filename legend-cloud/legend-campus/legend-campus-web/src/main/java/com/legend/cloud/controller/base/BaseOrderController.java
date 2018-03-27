package com.legend.cloud.controller.base;


        import com.legend.module.core.model.contant.arribute.Column;
        import com.legend.module.core.model.contant.arribute.Key;
        import com.legend.module.core.model.contant.code.result.AjaxCode;
        import com.legend.module.core.model.contant.message.result.AjaxMessage;
        import com.legend.module.core.model.json.result.Ajax;
        import com.legend.module.core.model.json.result.AjaxValidate;
        import com.legend.module.core.utils.PageUtils;
        import com.legend.module.core.utils.Query;
        import com.legend.module.core.web.controller.LegendController;
        import com.legend.cloud.entity.base.BaseOrder;
        import com.legend.cloud.service.base.BaseOrderService;
        import com.legend.cloud.vo.base.BaseOrderVO;
        import org.springframework.validation.BindingResult;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/base/order")
public class BaseOrderController extends LegendController {

    @Resource
    private BaseOrderService baseOrderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("base:order:list")
    public Ajax list(BaseOrderVO baseOrderVO, Query query) {
        try {
            List<BaseOrder> baseOrderList = baseOrderService.getList(baseOrderVO.parseTo(),
                    query);
            List<BaseOrderVO> baseOrderVOList = baseOrderList.stream().map((entity) ->
                    new BaseOrderVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(baseOrderVOList, baseOrderVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("base:order:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseOrder baseOrder =baseOrderService.getById(id);
                BaseOrderVO baseOrderVO = new BaseOrderVO().parseFrom(baseOrder);
            return Ajax.success(baseOrderVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("base:order:add")
    public Ajax add(@Validated BaseOrderVO baseOrderVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = baseOrderService.save(baseOrderVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("base:order:update")
    public Ajax update(@Validated BaseOrderVO baseOrderVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = baseOrderService.updateById(baseOrderVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("base:order:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseOrderService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
