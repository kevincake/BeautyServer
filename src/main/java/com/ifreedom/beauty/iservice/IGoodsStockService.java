package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.GoodsStockEntity;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:库存
 */
public interface IGoodsStockService {
    GoodsStockEntity addGoods2Stock(GoodsStockEntity stockEntity);

    long getSuplus(Long goodsId);
}
