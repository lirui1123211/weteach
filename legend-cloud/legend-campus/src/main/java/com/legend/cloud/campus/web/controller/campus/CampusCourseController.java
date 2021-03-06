package com.legend.cloud.campus.web.controller.campus;


import com.legend.cloud.campus.facade.CoursePublishFacade;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourse;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLimit;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserRelCourse;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusAccountVO;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusCourseVO;
import com.legend.cloud.campus.model.pojo.vo.campus.complex.CoursePublishVO;
import com.legend.cloud.campus.service.base.BaseUserService;
import com.legend.cloud.campus.service.campus.CampusAccountService;
import com.legend.cloud.campus.service.campus.CampusCourseLimitService;
import com.legend.cloud.campus.service.campus.CampusCourseService;
import com.legend.cloud.campus.service.campus.CampusUserRelCourseService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.model.pojo.vo.user.UserVO;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Jim
 * @date 2018/4/6
 */
@RestController
@RequestMapping("/campus/course")
public class CampusCourseController extends CampusController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CampusCourseController.class);

    @Resource
    private CampusCourseService campusCourseService;
    @Resource
    private CoursePublishFacade coursePublishFacade;
    @Resource
    private CampusCourseLimitService campusCourseLimitService;
    @Resource
    private BaseUserService baseUserService;
    @Resource
    private CampusAccountService campusAccountService;
    @Resource
    private CampusUserRelCourseService campusUserRelCourseService;

    @GetMapping("/list")
    @RequiresPermissions("campus:course:list")
    public Ajax list(CampusCourseVO campusCourseVO, QueryUtils query) {
        try {
            List<CampusCourse> campusCourseList = campusCourseService.getList(campusCourseVO.parseTo(),
                    query);
            List<CampusCourseVO> campusCourseVOList = new CampusCourseVO().parseFrom(campusCourseList);
            PageUtils pageUtils = new PageUtils(campusCourseVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (AuthorizationException e) {
            return Ajax.error();
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("details/{id}")
    // @RequiresPermissions("campus:course:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourse campusCourse = campusCourseService.getById(id);
            CampusCourseVO campusCourseVO = new CampusCourseVO().parseFrom(campusCourse);
            return Ajax.success(campusCourseVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:course:add")
    public Ajax add(@Validated CoursePublishVO coursePublishVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            Subject subject = SecurityUtils.getSubject();
            UserVO currentUser = (UserVO) subject.getPrincipal();
            CampusCourse campusCourse = coursePublishVO.getCourse().parseTo(Column.ID);
            campusCourse.setUserId(currentUser.getId());
            CampusCourseLimit campusCourseLimit = coursePublishVO.getLimit() != null ? coursePublishVO.getLimit().parseTo
                    (Column.ID) : null;
            return coursePublishFacade.publish(campusCourse, campusCourseLimit, currentUser.getTypeUser()) == 1 ? Ajax.success
                    (AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE,
                    AjaxCode.SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    //验证报名资格
    @PutMapping("/apply/{courseId}")
    public Ajax apply(@PathVariable Integer courseId) {
        CampusCourse campusCourse = campusCourseService.getById(courseId);
        if (campusCourse == null) {
            return Ajax.error("课程不存在");
        }
        long now = System.currentTimeMillis();
        if (campusCourse.getApplyEndTime() != null) {
            if (now > campusCourse.getApplyEndTime().getTime()) {
                return Ajax.error("报名时间已过");
            }
        }
        CampusCourseLimit campusCourseLimit = new CampusCourseLimit();
        campusCourseLimit.setCourseId(courseId);
        campusCourseLimit = campusCourseLimitService.get(campusCourseLimit);
        if (campusCourseLimit == null) {
            return Ajax.success("验证报名资格成功");
        }
        if (campusCourse.getLessonNum() >= campusCourseLimit.getPersonUpper()) {
            return Ajax.error("该课程人数已满");
        }
        Subject subject = SecurityUtils.getSubject();
        UserVO currentUser = (UserVO) subject.getPrincipal();
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        subject.runAs(new SimplePrincipalCollection(currentUser, realmName));
        CampusAccountVO campusAccountVO = new CampusAccountVO().parseFrom(campusAccountService.getByUserId(currentUser.getId()));
        if (campusCourseLimit.getSex() != null) {
            if ((campusAccountVO.getSex() && campusCourseLimit.getSex() == 0) || (!campusAccountVO.getSex() && campusCourseLimit.getSex() == 1)) {
                return Ajax.error("您的性别不符合限制条件");
            }
        }
        if (campusCourseLimit.getMajor() != null) {
            if (campusCourseLimit.getMajor() != Integer.parseInt(campusAccountVO.getMajor())) {
                return Ajax.error("您的专业不符合限制条件");
            }
        }
        if (campusCourseLimit.getGrade() != null) {
            String grade = campusCourseLimit.getGrade().toString();
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int[] a = new int[grade.length()];
            for (int i = 0; i < a.length; i++) {
                if ((year - Integer.parseInt(campusAccountVO.getEnrollmentYear())) == Integer.parseInt(grade.substring(i, i + 1))) {
                    return Ajax.success("验证报名资格成功");
                }
            }
            return Ajax.error("您的年级不符合限制条件");
        }
        return Ajax.success("验证报名资格成功");

    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:course:update")
    public Ajax update(@Validated CampusCourseVO campusCourseVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusCourseService.updateById(campusCourseVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    // @RequiresPermissions("campus:course:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    //确认报名
    @PutMapping("/yesToApply/{id}")
    public Ajax yesToApply(@PathVariable Integer id) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UserVO currentUser = (UserVO) subject.getPrincipal();
            String realmName = subject.getPrincipals().getRealmNames().iterator().next();
            subject.runAs(new SimplePrincipalCollection(currentUser, realmName));
            CampusAccountVO campusAccountVO = new CampusAccountVO().parseFrom(campusAccountService.getByUserId(currentUser.getId()));
            CampusUserRelCourse campusUserRelCourse = new CampusUserRelCourse();
            campusUserRelCourse.setCourseId(id);
            campusUserRelCourse.setUserId(currentUser.getId());
            campusUserRelCourse.setCreateTime(new Date());
            int result = campusUserRelCourseService.save(campusUserRelCourse);
            CampusCourse campusCourse = campusCourseService.getById(id);
            campusCourse.setLessonNum(campusCourse.getLessonNum() + 1);
            int credits = Integer.parseInt(campusAccountVO.getDirection()) - campusCourse.getPayCredits();
            if (credits <= 0) {
                return Ajax.error("对不起，您的积分不够");
            }
            campusAccountVO.setDirection("" + credits);
            result += campusCourseService.updateById(campusCourse);
            result += campusAccountService.updateById(campusAccountVO.parseTo());
            return result == 3 ? Ajax.success("报名成功") : Ajax.error(AjaxMessage.SAVE_FAILURE,
                    AjaxCode.SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }
}
