package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.repository.GoodsPropKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Service
public class GoodsPropKeyService {
    @Autowired
    GoodsPropKeyRepository goodsPropKeyRepository;

    public GoodsPropertyKeyEntity addGoodsPropKey(GoodsPropertyKeyEntity goodsPropertyKeyEntity) {
        return goodsPropKeyRepository.addGoodsKeyProp(goodsPropertyKeyEntity);
    }

    ;

    public GoodsPropertyKeyEntity deleteGoodsPropKey(GoodsPropertyKeyEntity goodsPropertyKeyEntity) {
        return goodsPropKeyRepository.delete(goodsPropertyKeyEntity.getId());
    }

    public GoodsPropertyKeyEntity getGoodsPropKey(Long goodsId) {
        return goodsPropKeyRepository.getPropKey(goodsId);
    }

    ;
}
