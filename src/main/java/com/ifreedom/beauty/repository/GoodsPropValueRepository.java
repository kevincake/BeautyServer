package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.entity.GoodsPropertyValueEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Component
public class GoodsPropValueRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public GoodsPropertyValueEntity addGoodsValueProp(GoodsPropertyValueEntity goodsPropertyValueEntity) {
        return entityManager.merge(goodsPropertyValueEntity);
    }

    @Transactional
    public GoodsPropertyValueEntity delete(Long id) {
        GoodsPropertyValueEntity goodsPropertyValueEntity = entityManager.find(GoodsPropertyValueEntity.class, id);
        if (goodsPropertyValueEntity != null) {
            entityManager.remove(goodsPropertyValueEntity);
        }
        return goodsPropertyValueEntity;
    }

    public List<GoodsPropertyValueEntity> getGoodsPropValueList(Long goodsId, Long keyId) {
        String sql = "select * from goodsPropertyValue where goodsId = :goodsId and goodsProperKeyId = :keyId";
        Query nativeQuery = entityManager.createNativeQuery(sql, GoodsPropertyValueEntity.class);
        nativeQuery.setParameter("goodsId", goodsId).setParameter("keyId", keyId);
        List<GoodsPropertyValueEntity> resultList = nativeQuery.getResultList();
        return resultList;
    }
}
