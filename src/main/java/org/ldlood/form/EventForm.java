package org.ldlood.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ldlood on 2017/8/10.
 */
@Data
public class EventForm {

    private String EventId;

    /**
     * 名字.
     */
    private String EventName;

    /**
     * 单价.
     */
    private BigDecimal EventPrice;

    /**
     * 库存.
     */
    private Integer EventStock;

    /**
     * 描述.
     */
    private String EventDescription;

    /**
     * 小图.
     */
    private String EventIcon;

    public String getEventId() {
        return EventId;
    }

    public void setEventId(String EventId) {
        this.EventId = EventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public BigDecimal getEventPrice() {
        return EventPrice;
    }

    public void setEventPrice(BigDecimal EventPrice) {
        this.EventPrice = EventPrice;
    }

    public Integer getEventStock() {
        return EventStock;
    }

    public void setEventStock(Integer EventStock) {
        this.EventStock = EventStock;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String EventDescription) {
        this.EventDescription = EventDescription;
    }

    public String getEventIcon() {
        return EventIcon;
    }

    public void setEventIcon(String EventIcon) {
        this.EventIcon = EventIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
