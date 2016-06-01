package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.*;
import com.ifreedom.beauty.service.*;
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
    @Autowired
    GoodsPropKeyService keyService;
    @Autowired
    GoodsPropValueService valueService;
    @Autowired
    GoodsStockService goodsStockService;
    @Autowired
    PicService picService;
    @Autowired
    CourseGoodsService courseGoodsService;

    @Test
    public void batchAddGoods() {
        for (int i = 0; i < 10; i++) {
            GoodsExtEntity goodsExtEntity = new GoodsExtEntity();
            goodsExtEntity.setDetailDes("这里面有详细信息");
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsDes("美宝莲水彩笔");
            goodsEntity.setGoodsName("水彩笔");
            goodsEntity.setGoodsPrice(100L);
            goodsEntity.setGoodsType(DataBaseConstants.GOODS_PAINT_TYPE);
//            goodsEntity.setGoodsExtEntity(goodsExtEntity);
            GoodsEntity goodsEntitySave = goodsService.addGoods(goodsEntity);
            goodsExtEntity.setGoodsId(goodsEntitySave.getId());
            //给商品添加一系列的属性key
            GoodsPropertyKeyEntity propertyKeyEntity = new GoodsPropertyKeyEntity();
            propertyKeyEntity.setGoodsId(goodsEntitySave.getId());
            propertyKeyEntity.setPropertyName("颜色");
            GoodsPropertyKeyEntity savePropKey = keyService.addGoodsPropKey(propertyKeyEntity);
            //给商品添加一系列的属性value
            GoodsPropertyValueEntity valueEntity = new GoodsPropertyValueEntity();
            valueEntity.setPropertyValue("红色的");
            valueEntity.setGoodsProperKeyId(propertyKeyEntity.getId());
            valueEntity.setGoodsId(goodsEntitySave.getId());
            valueEntity.setGoodsProperKeyId(savePropKey.getId());
            valueService.addGoodsPropValue(valueEntity);

            GoodsStockEntity goodsStockEntity = new GoodsStockEntity();
            goodsStockEntity.setGoodsId(goodsEntitySave.getId());
            goodsStockEntity.setTotalCount(100L);
            goodsStockEntity.setSurplusCount(100L);
            goodsStockService.addGoods2Stock(goodsStockEntity);

            //给商品添加图片
            PicEntity picEntity = new PicEntity();
            picEntity.setType(DataBaseConstants.GOODS_PIC_TYPE);
            picEntity.setBelongId(goodsEntitySave.getId());
            picEntity.setUrl("http://beautybucket.oss-cn-shenzhen.aliyuncs.com/1462709283670.jpeg");
            picService.addPic(picEntity);
        }
    }

    @Test
    public void addGoodsCourse() {
        CourseGoodsEntity courseGoodsEntity = new CourseGoodsEntity();
        courseGoodsEntity.setGoodsId(1L);
        courseGoodsEntity.setGoodsId(2L);
        courseGoodsEntity.setGoodsId(3L);
        courseGoodsEntity.setCourseId(1L);
        courseGoodsService.addCourseGoods(courseGoodsEntity);
    }

}
