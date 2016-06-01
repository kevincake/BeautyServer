package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.CourseGoodsEntity;
import com.ifreedom.beauty.entity.GoodsEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
public interface ICourseGoodsService {
    List<GoodsEntity> getGoosList(Long courseId);

    CourseGoodsEntity addCourseGoods(CourseGoodsEntity courseGoodsEntity);
}
