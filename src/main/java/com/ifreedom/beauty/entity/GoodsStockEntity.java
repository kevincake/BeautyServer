package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:库存
 */
@Entity
@Table(name = "goodsStock")
public class GoodsStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long goodsId;
    private Long totalCount;
    private Long surplusCount;

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

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getSurplusCount() {
        return surplusCount;
    }

    public void setSurplusCount(Long surplusCount) {
        this.surplusCount = surplusCount;
    }
}
