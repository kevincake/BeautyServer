package com.ifreedom.beauty.service;

import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.GoodsShopCarEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.iservice.IGoodsShopCarService;
import com.ifreedom.beauty.repository.GoodsShopCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @atuhor:eavawu
 * @date:5/31/16
 * @todo:购物车的service
 */
@Service
public class GoodsShopCarService implements IGoodsShopCarService {
    @Autowired
    GoodsStockService goodsStockService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsShopCarRepository goodsShopCarRepository;

    @Override
    public int addGoods2ShopCar(GoodsShopCarEntity goodsShopCarEntity) {
        boolean has = goodsStockService.hasGoods(goodsShopCarEntity.getGoodsId());
        if (has) {
            GoodsShopCarEntity goodsShopCarEntitySave = goodsShopCarRepository.add2GoodsShopCar(goodsShopCarEntity);
            return DataBaseConstants.SUCCESS;
        }
        return DataBaseConstants.FAILED;
    }

    public int removeGoodFromShopCar(GoodsShopCarEntity goodsShopCarEntity) {
        boolean has = goodsStockService.hasGoods(goodsShopCarEntity.getGoodsId());
        if (has) {
            GoodsShopCarEntity goodsShopCarEntitySave = goodsShopCarRepository.deleteGoodsFromShopCar(goodsShopCarEntity.getId());
            return DataBaseConstants.SUCCESS;
        }
        return DataBaseConstants.FAILED;
    }


}
