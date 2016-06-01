package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsShopCarEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:
 */
@Component
public class GoodsShopCarRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public GoodsShopCarEntity add2GoodsShopCar(GoodsShopCarEntity goodsShopCarEntity) {
        return entityManager.merge(goodsShopCarEntity);
    };

    @Transactional
    public GoodsShopCarEntity deleteGoodsFromShopCar(Long id) {
        GoodsShopCarEntity goodsShopCarEntity = entityManager.find(GoodsShopCarEntity.class, id);
        if (goodsShopCarEntity != null) {
            entityManager.remove(goodsShopCarEntity);
        }
        return goodsShopCarEntity;
    }



}
