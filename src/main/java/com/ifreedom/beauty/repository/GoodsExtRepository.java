package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsExtEntity;
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
public class GoodsExtRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public GoodsExtEntity addGoodsExt(GoodsExtEntity goodsExtEntity) {
        return entityManager.merge(goodsExtEntity);
    }

}
