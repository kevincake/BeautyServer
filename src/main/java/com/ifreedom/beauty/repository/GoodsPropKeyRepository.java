package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Component
public class GoodsPropKeyRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public GoodsPropertyKeyEntity addGoodsKeyProp(GoodsPropertyKeyEntity goodsPropertyKeyEntity) {
        return entityManager.merge(goodsPropertyKeyEntity);
    }

    @Transactional
    public GoodsPropertyKeyEntity delete(Long id) {
        GoodsPropertyKeyEntity goodsPropertyKeyEntity = entityManager.find(GoodsPropertyKeyEntity.class, id);
        if (goodsPropertyKeyEntity != null) {
            entityManager.remove(goodsPropertyKeyEntity);
        }
        return goodsPropertyKeyEntity;
    }

    public GoodsPropertyKeyEntity getPropKey(Long goodsId) {
        String sql = "select * from goodsPropertyKey where goodsId = :goodsId";
        Query nativeQuery = entityManager.createNativeQuery(sql, GoodsPropertyKeyEntity.class);
        nativeQuery.setParameter("goodsId", goodsId);
        if (nativeQuery.getResultList().isEmpty()) {
            return null;
        } else {
            return (GoodsPropertyKeyEntity) nativeQuery.getResultList().get(0);
        }

    }
}
