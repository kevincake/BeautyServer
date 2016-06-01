package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.GoodsPropertyValueEntity;
import com.ifreedom.beauty.iservice.IGoodsPropValueService;
import com.ifreedom.beauty.repository.GoodsPropValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Service
public class GoodsPropValueService implements IGoodsPropValueService {
    @Autowired
    GoodsPropValueRepository valueRepository;

    @Override
    public GoodsPropertyValueEntity addGoodsPropValue(GoodsPropertyValueEntity goodsPropertyValueEntity) {
        return valueRepository.addGoodsValueProp(goodsPropertyValueEntity);
    }

    @Override
    public List<GoodsPropertyValueEntity> getGoodsPropValueList(Long goodsId, Long id) {
        return valueRepository.getGoodsPropValueList(goodsId,id);
    }
}
