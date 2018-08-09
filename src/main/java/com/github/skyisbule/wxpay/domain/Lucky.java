package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Lucky implements Serializable {
    /**
     * 单纯的主键
     */
    private Integer lid;

    /**
     * 奖品id
     */
    private Integer awardId;

    /**
     * 中奖人
     */
    private String uuid;

    /**
     * 头像链接
     */
    private String headPic;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 奖品的个数或者金钱的钱数
     */
    private Integer awardNum;

    private String formId;

    private static final long serialVersionUID = 1L;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
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
        Lucky other = (Lucky) that;
        return (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
            && (this.getAwardId() == null ? other.getAwardId() == null : this.getAwardId().equals(other.getAwardId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getHeadPic() == null ? other.getHeadPic() == null : this.getHeadPic().equals(other.getHeadPic()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getAwardNum() == null ? other.getAwardNum() == null : this.getAwardNum().equals(other.getAwardNum()))
            && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getAwardId() == null) ? 0 : getAwardId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getHeadPic() == null) ? 0 : getHeadPic().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getAwardNum() == null) ? 0 : getAwardNum().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lid=").append(lid);
        sb.append(", awardId=").append(awardId);
        sb.append(", uuid=").append(uuid);
        sb.append(", headPic=").append(headPic);
        sb.append(", nickName=").append(nickName);
        sb.append(", awardNum=").append(awardNum);
        sb.append(", formId=").append(formId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}