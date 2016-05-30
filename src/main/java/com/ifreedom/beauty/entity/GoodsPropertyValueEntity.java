package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:商品的属性值
 */
@Entity
@Table(name = "goodsPropertyValue")
public class GoodsPropertyValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long goodId;
    private Long goodsProperKeyId;
    private Long value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getGoodsProperKeyId() {
        return goodsProperKeyId;
    }

    public void setGoodsProperKeyId(Long goodsProperKeyId) {
        this.goodsProperKeyId = goodsProperKeyId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
