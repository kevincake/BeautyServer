package com.ifreedom.beauty.entity;

import com.ifreedom.beauty.bean.GoodsDetail;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/26/16
 * @todo:
 */
@Entity
@Table(name = "goods")
public class GoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long goodsType;
    private String goodsName;
    private Long goodsPrice;
    private String goodsDes;
    private String unit;
    private long star;

    @Transient
    GoodsExtEntity goodsExtEntity;

    public GoodsExtEntity getGoodsExtEntity() {
        return goodsExtEntity;
    }

    public void setGoodsExtEntity(GoodsExtEntity goodsExtEntity) {
        this.goodsExtEntity = goodsExtEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Long goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }
}
