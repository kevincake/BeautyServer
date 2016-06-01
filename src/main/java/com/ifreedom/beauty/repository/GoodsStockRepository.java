package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.GoodsStockEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:
 */
@Component
public class GoodsStockRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public GoodsStockEntity addGoods2Stock(GoodsStockEntity goodsStockEntity) {
        return entityManager.merge(goodsStockEntity);
    }


    public Long getSuplus(Long goodsId) {
        String sql = "select surplusCount from goodStock where goodsId = :goodsId";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.setParameter("goodsId", goodsId);
        List resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()) {
            return 0L;
        } else {
            return (Long) resultList.get(0);
        }
    }
}
