package com.ifreedom.beauty.bean;

import com.ifreedom.beauty.entity.GoodsPropertyKeyEntity;
import com.ifreedom.beauty.entity.GoodsPropertyValueEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:
 */
public class GoodsProperty {
    private GoodsPropertyKeyEntity propertyKey;
    private List<GoodsPropertyValueEntity> propertyValues;

    public GoodsPropertyKeyEntity getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(GoodsPropertyKeyEntity propertyKey) {
        this.propertyKey = propertyKey;
    }

    public List<GoodsPropertyValueEntity> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<GoodsPropertyValueEntity> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
