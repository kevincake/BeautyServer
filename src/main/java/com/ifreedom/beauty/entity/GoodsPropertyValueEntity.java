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
    private Long goodsId;
    private Long goodsProperKeyId;
    private String propertyValue;
    private String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsProperKeyId() {
        return goodsProperKeyId;
    }

    public void setGoodsProperKeyId(Long goodsProperKeyId) {
        this.goodsProperKeyId = goodsProperKeyId;
    }



}
