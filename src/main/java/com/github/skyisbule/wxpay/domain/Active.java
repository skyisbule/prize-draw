package com.github.skyisbule.wxpay.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Active implements Serializable {
    /**
     * 活动id
     */
    private Integer acid;

    /**
     * 发布者id
     */
    private String uuid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 关联的抽奖id
     */
    private Integer prizeId;

    /**
     * 头像链接
     */
    private String headPic;

    /**
     * 昵称
     */
    private String nickName;

    private static final long serialVersionUID = 1L;

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
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
        Active other = (Active) that;
        return (this.getAcid() == null ? other.getAcid() == null : this.getAcid().equals(other.getAcid()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getHeadPic() == null ? other.getHeadPic() == null : this.getHeadPic().equals(other.getHeadPic()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcid() == null) ? 0 : getAcid().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getHeadPic() == null) ? 0 : getHeadPic().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", acid=").append(acid);
        sb.append(", uuid=").append(uuid);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", prizeId=").append(prizeId);
        sb.append(", headPic=").append(headPic);
        sb.append(", nickName=").append(nickName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}