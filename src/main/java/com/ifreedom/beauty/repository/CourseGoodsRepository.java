package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.service.GoodsService;
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

    //根据课程获取商品列表
    @Transactional
    public List<GoodsEntity> getGoodsList(Long courseId) {
        String sql = "select goodsId from courseGoods where courseId = :courseId";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List<Long> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            List<GoodsEntity> goodsList = new ArrayList<>();
            for (Long goodsId : resultList) {
                GoodsEntity goods = goodsService.getGoods(goodsId);
                goodsList.add(goods);
            }
            return goodsList;
        }
    }


}
