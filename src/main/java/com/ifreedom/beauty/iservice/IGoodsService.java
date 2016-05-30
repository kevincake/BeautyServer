package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.bean.GoodsDetail;
import com.ifreedom.beauty.entity.GoodsEntity;

/**
 * @atuhor:eavawu
 * @date:5/28/16
 * @todo:
 */
public interface IGoodsService {
    GoodsEntity addGoods(GoodsEntity goodsEntity);
    GoodsEntity getGoods(Long goodsId);
}
