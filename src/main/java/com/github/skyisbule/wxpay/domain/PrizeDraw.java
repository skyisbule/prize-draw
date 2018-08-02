package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class PrizeDraw implements Serializable {
    private Integer prizeId;

    /**
     * 发起者的id
     */
    private String uuid;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建这个抽奖的时间
     */
    private Date createTime;

    /**
     * 若选择定时开奖，则传它进来，到期自动开奖。
     */
    private Date expireTime;

    /**
     * 是否已经结束，若结束则外人不得接着抽奖。
     */
    private Integer isClosed;

    private static final long serialVersionUID = 1L;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
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
        PrizeDraw other = (PrizeDraw) that;
        return (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getIsClosed() == null ? other.getIsClosed() == null : this.getIsClosed().equals(other.getIsClosed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getIsClosed() == null) ? 0 : getIsClosed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prizeId=").append(prizeId);
        sb.append(", uuid=").append(uuid);
        sb.append(", title=").append(title);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", isClosed=").append(isClosed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}