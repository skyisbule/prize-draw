package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Partake implements Serializable {
    private Integer pid;

    /**
     * 用户ID
     */
    private String uuid;

    /**
     * 抽奖的id
     */
    private Integer prizeId;

    /**
     * 是否中奖
     */
    private Integer isLucky;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像链接
     */
    private String headPic;

    private String formId;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getIsLucky() {
        return isLucky;
    }

    public void setIsLucky(Integer isLucky) {
        this.isLucky = isLucky;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
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
        Partake other = (Partake) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getIsLucky() == null ? other.getIsLucky() == null : this.getIsLucky().equals(other.getIsLucky()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getHeadPic() == null ? other.getHeadPic() == null : this.getHeadPic().equals(other.getHeadPic()))
            && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getIsLucky() == null) ? 0 : getIsLucky().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getHeadPic() == null) ? 0 : getHeadPic().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", uuid=").append(uuid);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", isLucky=").append(isLucky);
        sb.append(", nickName=").append(nickName);
        sb.append(", headPic=").append(headPic);
        sb.append(", formId=").append(formId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}