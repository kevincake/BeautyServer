package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @atuhor:eavawu
 * @date:5/28/16
 * @todo:
 */
@Component
public class GoodsRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    GoodsExtRepository goodsExtRepository;

    @Transactional
    public GoodsEntity addGoods(GoodsEntity goodsEntity) {
        if (goodsEntity.getGoodsExtEntity() != null) {
            goodsExtRepository.addGoodsExt(goodsEntity.getGoodsExtEntity());
        }
        return entityManager.merge(goodsEntity);
    }

}
