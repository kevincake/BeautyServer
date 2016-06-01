package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.service.CourseGoodsService;
import com.ifreedom.beauty.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @atuhor:eavawu
 * @date:6/1/16
 * @todo:
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CourseGoodsService courseGoodsService;
    @ResponseBody
    @RequestMapping(value = "/getGoodsList", method = RequestMethod.GET)
    public HttpResult getGoodsListByCourseId(@RequestParam("courseId") Long courseId) {
        HttpResult result = new HttpResult();
        result.setResultCode(HttpConstants.SUCCESS);
        result.getData().put(HttpConstants.GOODSLIST, courseGoodsService.getGoosList(courseId));
        return result;
    }


}
