package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.GoodsShopCarEntity;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:购物车
 */
public interface IGoodsShopCarService {
    int addGoods2ShopCar(GoodsShopCarEntity goodsShopCarEntity);
}
