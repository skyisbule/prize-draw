package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Award implements Serializable {
    /**
     * 奖品ID，主键自增。
     */
    private Integer aid;

    /**
     * 上层的抽奖id
     */
    private Integer prizeId;

    /**
     * 奖品的标题也就是名称
     */
    private String title;

    /**
     * 中奖人数
     */
    private Integer luckyNum;

    /**
     * 0是实物 1是现金
     */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLuckyNum() {
        return luckyNum;
    }

    public void setLuckyNum(Integer luckyNum) {
        this.luckyNum = luckyNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Award other = (Award) that;
        return (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getLuckyNum() == null ? other.getLuckyNum() == null : this.getLuckyNum().equals(other.getLuckyNum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getLuckyNum() == null) ? 0 : getLuckyNum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", title=").append(title);
        sb.append(", luckyNum=").append(luckyNum);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}