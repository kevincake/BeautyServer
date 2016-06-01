package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.GoodsProperty;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.entity.GoodsPropertyValueEntity;
import com.ifreedom.beauty.service.GoodsPropKeyService;
import com.ifreedom.beauty.service.GoodsPropValueService;
import com.ifreedom.beauty.service.GoodsStockService;
import com.ifreedom.beauty.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    @Autowired
    PicService picService;
    @Autowired
    GoodsPropKeyService propKeyService;
    @Autowired
    GoodsPropValueService propValueService;
    @Autowired
    GoodsStockService goodsStockService;

    @Transactional
    public GoodsEntity addGoods(GoodsEntity goodsEntity) {

        return entityManager.merge(goodsEntity);
    }

    public GoodsEntity getGoods(Long goodsId) {
        GoodsEntity goodsEntity = entityManager.find(GoodsEntity.class, goodsId);
        if (goodsEntity != null) {
            //查询属性
            GoodsPropertyKeyEntity goodsPropKey = propKeyService.getGoodsPropKey(goodsId);
            List<GoodsPropertyValueEntity> goodsPropValueList = propValueService.getGoodsPropValueList(goodsId, goodsPropKey.getId());
            GoodsProperty goodsProperty = new GoodsProperty();
            goodsProperty.setPropertyKey(goodsPropKey);
            goodsProperty.setPropertyValues(goodsPropValueList);
            goodsEntity.setGoodsProperty(goodsProperty);
            //赋值库存属性
            goodsEntity.setSurplus(goodsStockService.getSuplus(goodsId));
            //查出图片
            List<String> pictures = picService.getPictures(DataBaseConstants.GOODS_PIC_TYPE, goodsId);
            goodsEntity.setPics(pictures);
        }


        return goodsEntity;
    }
}
