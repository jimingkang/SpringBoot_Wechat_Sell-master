package org.ldlood.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ldlood.enums.EventStatusEnum;
import org.ldlood.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ldlood on 2017/7/20.
 */
@Entity
@Data
@DynamicUpdate
public class EventInfo {

    @Id
    private String eventId;

    /**
     * 名字.
     */
    private String eventName;

    /**
     * 单价.
     */
    private BigDecimal eventPrice;

    /**
     * 库存.
     */
    private Integer eventStock;



    /**
     * 描述.
     */
    private String eventDescription;

    /**
     * 小图.
     */
    private String eventIcon;

    /**
     * 状态, 0正常1下架.
     */
    private Integer eventStatus =0;// eventStatusEnum.UP.getCode();

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(BigDecimal eventPrice) {
        this.eventPrice = eventPrice;
    }

    public Integer getEventStock() {
        return eventStock;
    }

    public void setEventStock(Integer eventStock) {
        this.eventStock = eventStock;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventIcon() {
        return eventIcon;
    }

    public void setEventIcon(String eventIcon) {
        this.eventIcon = eventIcon;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
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
     * 更新时间
     */
    private Date updateTime;

    @JsonIgnore
    public EventStatusEnum getEventStatusEnum() {

        return EnumUtil.getByCode(eventStatus, EventStatusEnum.class);
    }
}
