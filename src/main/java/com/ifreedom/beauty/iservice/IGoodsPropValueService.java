package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.GoodsPropertyValueEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
@Service
public interface IGoodsPropValueService {
    GoodsPropertyValueEntity addGoodsPropValue(GoodsPropertyValueEntity goodsPropertyValueEntity);

    List<GoodsPropertyValueEntity> getGoodsPropValueList(Long goodsId, Long id);
}
