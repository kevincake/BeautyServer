package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.iservice.IGoodsService;
import com.ifreedom.beauty.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:eavawu
 * @date:5/28/16
 * @todo:
 */
@Service
public class GoodsService implements IGoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    @Override
    public GoodsEntity addGoods(GoodsEntity goodsEntity) {

        return goodsRepository.addGoods(goodsEntity);
    }

    @Override
    public GoodsEntity getGoods(Long goodsId) {
        return goodsRepository.getGoods(goodsId);
    }


}
