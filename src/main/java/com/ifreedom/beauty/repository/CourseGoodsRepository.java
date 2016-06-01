package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.GoodsProperty;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.CourseGoodsEntity;
import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.service.GoodsPropKeyService;
import com.ifreedom.beauty.service.GoodsPropValueService;
import com.ifreedom.beauty.service.GoodsService;
import com.ifreedom.beauty.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:课程商品关联表
 */
@Component
public class CourseGoodsRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsPropKeyService keyService;
    @Autowired
    GoodsPropValueService valueService;
    @Autowired
    PicService picService;

    //根据课程获取商品列表
    @Transactional
    public List<GoodsEntity> getGoodsList(Long courseId) {
        String sql = "select * from goods where (select goodsId from courseGoods where courseId = :courseId)";
        Query nativeQuery = entityManager.createNativeQuery(sql, GoodsEntity.class);
        nativeQuery.setParameter("courseId", courseId);
        List<GoodsEntity> resultList = nativeQuery.getResultList();
        for (GoodsEntity goodsEntity : resultList) {
            //设置图片
            List<String> pictures = picService.getPictures(DataBaseConstants.GOODS_PIC_TYPE, goodsEntity.getId());
            goodsEntity.setPics(pictures);
            //设置属性
            GoodsProperty goodsProperty = new GoodsProperty();
            GoodsPropertyKeyEntity goodsPropKey = keyService.getGoodsPropKey(goodsEntity.getId());
            goodsProperty.setPropertyKey(goodsPropKey);
            goodsProperty.setPropertyValues(valueService.getGoodsPropValueList(goodsEntity.getId(), goodsPropKey.getId()));
            goodsEntity.setGoodsProperty(goodsProperty);
        }

        return resultList;

    }

    @Transactional
    public CourseGoodsEntity addCourseGoods(CourseGoodsEntity courseGoodsEntity) {
        return entityManager.merge(courseGoodsEntity);
    }
}
