package org.ldlood.dto;

import lombok.Data;

/**
 * Created by Ldlood on 2017/7/22.
 */
@Data
public class CartDTO {
    /**
     * 商品Id.
     */
    private String eventId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        eventId = eventId;
    }

    public Integer getEventQuantity() {
        return eventQuantity;
    }

    public void setEventQuantity(Integer eventQuantity) {
        this.eventQuantity = eventQuantity;
    }

    /**
     * 数量.
     */
    private Integer eventQuantity;

    public CartDTO(String eventId, Integer eventQuantity) {
        this.eventId = eventId;
        this.eventQuantity = eventQuantity;
    }
}
