package com.ifreedom.beauty.entity;

/**
 * @atuhor:eavawu
 * @date:5/25/16
 * @todo:
 */
public class PicEntity {
    private Long id;
    private Long belongId;
    private int type;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBelongId() {
        return belongId;
    }

    public void setBelongId(Long belongId) {
        this.belongId = belongId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
