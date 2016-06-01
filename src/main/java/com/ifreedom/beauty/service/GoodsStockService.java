package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.GoodsStockEntity;
import com.ifreedom.beauty.iservice.IGoodsStockService;
import com.ifreedom.beauty.repository.GoodsStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:
 */
@Service
public class GoodsStockService implements IGoodsStockService {
    @Autowired
    GoodsStockRepository goodsStockRepository;

    @Override
    public GoodsStockEntity addGoods2Stock(GoodsStockEntity stockEntity) {
        return goodsStockRepository.addGoods2Stock(stockEntity);
    }

    @Override
    public long getSuplus(Long goodsId) {
        return goodsStockRepository.getSuplus(goodsId);
    }

    public boolean hasGoods(long goodsId){
        if (getSuplus(goodsId)>0){
            return true;
        }else{
            return false;
        }
    }


}
