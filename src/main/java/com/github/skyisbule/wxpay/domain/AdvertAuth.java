package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class AdvertAuth implements Serializable {
    private Integer authid;

    /**
     * 抽奖id
     */
    private Integer prizeId;

    /**
     * 领取用的key
     */
    private String receiveKey;

    /**
     * 是否被领取过
     */
    private Integer isClose;

    private static final long serialVersionUID = 1L;

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getReceiveKey() {
        return receiveKey;
    }

    public void setReceiveKey(String receiveKey) {
        this.receiveKey = receiveKey;
    }

    public Integer getIsClose() {
        return isClose;
    }

    public void setIsClose(Integer isClose) {
        this.isClose = isClose;
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
        AdvertAuth other = (AdvertAuth) that;
        return (this.getAuthid() == null ? other.getAuthid() == null : this.getAuthid().equals(other.getAuthid()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getReceiveKey() == null ? other.getReceiveKey() == null : this.getReceiveKey().equals(other.getReceiveKey()))
            && (this.getIsClose() == null ? other.getIsClose() == null : this.getIsClose().equals(other.getIsClose()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthid() == null) ? 0 : getAuthid().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getReceiveKey() == null) ? 0 : getReceiveKey().hashCode());
        result = prime * result + ((getIsClose() == null) ? 0 : getIsClose().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authid=").append(authid);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", receiveKey=").append(receiveKey);
        sb.append(", isClose=").append(isClose);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}