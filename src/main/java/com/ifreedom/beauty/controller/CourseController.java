package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.bean.PopularCourseBean;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.CourseEntity;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.CourseService;
import com.ifreedom.beauty.service.UserService;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/4/16
 * @todo:
 */


@RestController
@RequestMapping(HttpConstants.COURSE_CONTROL_PATH)
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;

    @Authorization
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public HttpResult getPopularCourseList(@CurrentUser UserEntity userEntity,@RequestParam("pageIndex") int pageIndex) {
        HttpResult result = new HttpResult();
        if (userEntity == null) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("userNotExist"));
            return result;
        }
        List<PopularCourseBean> courseList = courseService.getPopularCourseList(userEntity.getId(), DataBaseConstants.POPULAR,pageIndex);
        result.setResultCode(HttpConstants.SUCCESS);
        result.getData().put(HttpConstants.COURSELIST, courseList);
        return result;
    }


    @Authorization
    @ResponseBody
    @RequestMapping(value = HttpConstants.USERID_PATH, method = RequestMethod.POST)
    public HttpResult addCourse() {
        HttpResult result = new HttpResult();
        result.setResultCode(HttpConstants.SUCCESS);
        return result;
    }


}
