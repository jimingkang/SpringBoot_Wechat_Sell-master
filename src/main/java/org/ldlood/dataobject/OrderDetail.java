package org.ldlood.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Ldlood on 2017/7/21.
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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

    public Integer getEventQuantity() {
        return EventQuantity;
    }

    public void setEventQuantity(Integer EventQuantity) {
        this.EventQuantity = EventQuantity;
    }

    public String getEventIcon() {
        return EventIcon;
    }

    public void setEventIcon(String EventIcon) {
        this.EventIcon = EventIcon;
    }

    /** 商品id. */
    private String EventId;

    /** 商品名称. */
    private String EventName;

    /** 商品单价. */
    private BigDecimal EventPrice;

    /** 商品数量. */
    private Integer EventQuantity;

    /** 商品小图. */
    private String EventIcon;
}
