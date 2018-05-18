package org.ldlood.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Ldlood on 2017/7/21.
 */
@Data
public class EventInfoVO implements Serializable {


    private static final long serialVersionUID = 5836171251278038743L;

    @JsonProperty("id")
    private String EventId;

    @JsonProperty("name")
    private String EventName;

    @JsonProperty("price")
    private BigDecimal EventPrice;

    @JsonProperty("description")
    private String EventDescription;

    @JsonProperty("icon")
    private String EventIcon;
}
