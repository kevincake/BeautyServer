package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.CourseGoodsEntity;
import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.iservice.ICourseGoodsService;
import com.ifreedom.beauty.repository.CourseGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Service
public class CourseGoodsService implements ICourseGoodsService {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CourseGoodsRepository courseGoodsRepository;

    @Override
    public List<GoodsEntity> getGoosList(Long courseId) {
        return courseGoodsRepository.getGoodsList(courseId);
    }

    @Override
    public CourseGoodsEntity addCourseGoods(CourseGoodsEntity courseGoodsEntity) {
        return courseGoodsRepository.addCourseGoods(courseGoodsEntity);
    }
}
