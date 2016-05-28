package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.GoodsExtEntity;
import com.ifreedom.beauty.iservice.IGoodsExtService;
import com.ifreedom.beauty.repository.GoodsExtRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @atuhor:eavawu
 * @date:5/28/16
 * @todo:
 */
public class GoodsExtService implements IGoodsExtService{
    @Autowired
    GoodsExtRepository goodsExtRepository;
    @Override
    public GoodsExtEntity addGoodsExtEntity(GoodsExtEntity goodsExtEntity) {
        return goodsExtRepository.addGoodsExt(goodsExtEntity);
    }
}
