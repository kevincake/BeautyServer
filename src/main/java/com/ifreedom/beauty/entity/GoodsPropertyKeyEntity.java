package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:商品的属性key
 */
@Entity
@Table(name = "goodsPropertyKey")
public class GoodsPropertyKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String propertyName;
    private Long goodsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
