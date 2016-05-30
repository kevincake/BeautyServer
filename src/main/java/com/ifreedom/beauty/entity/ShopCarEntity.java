package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:5/30/16
 * @todo:购物车
 */
@Entity
@Table(name = "shopCar")
public class ShopCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long goodsId;
    private Long userId;
    private Long count;//放入购物车的商品数量

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
