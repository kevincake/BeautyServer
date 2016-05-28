package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.bean.GoodsDetail;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.GoodsEntity;
import com.ifreedom.beauty.entity.GoodsExtEntity;
import com.ifreedom.beauty.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @atuhor:eavawu
 * @date:5/28/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BeautyApplication.class)
@WebIntegrationTest
public class GoodsTest {
    @Autowired
    GoodsService goodsService;
    @Test
    public void batchAddGoods(){
        for (int i=0;i<10;i++){
            GoodsExtEntity goodsExtEntity = new GoodsExtEntity();
            goodsExtEntity.setDetailDes("这里面有详细信息");
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsDes("美宝莲水彩笔");
            goodsEntity.setGoodsName("水彩笔");
            goodsEntity.setGoodsPrice(100L);
            goodsEntity.setGoodsType(DataBaseConstants.GOODS_PAINT_TYPE);
            goodsEntity.setGoodsExtEntity(goodsExtEntity);
            goodsService.addGoods(goodsEntity);
        }
    }

}
