package com.ifreedom.beauty.entity;

import com.ifreedom.beauty.bean.GoodsDetail;
import com.ifreedom.beauty.bean.GoodsProperty;

import javax.persistence.*;
import java.util.List;

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

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    @Transient
    private List<String> pics;
    @Transient
    private Long surplus;//库存

    public Long getSurplus() {
        return surplus;
    }

    public void setSurplus(Long surplus) {
        this.surplus = surplus;
    }

    @Transient
    private GoodsProperty goodsProperty; //查询的时候,带出数据用
    @Transient
    private GoodsExtEntity goodsExtEntity;//查询的时候,带出数据用




    public GoodsExtEntity getGoodsExtEntity() {
        return goodsExtEntity;
    }

    public void setGoodsExtEntity(GoodsExtEntity goodsExtEntity) {
        this.goodsExtEntity = goodsExtEntity;
    }

    public GoodsProperty getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(GoodsProperty goodsProperty) {
        this.goodsProperty = goodsProperty;
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
