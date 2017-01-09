package com.jirawat.immutable.json.complex;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: juttayaya
 * Date: 12/31/16
 * Time: 2:24 PM
 */
@JsonEventType
interface JsonEvent {
    @Value.Immutable
    interface JsonEventOne extends JsonEvent {
        String name();
        BigDecimal size();
        @JsonProperty("dateMs") Date eventDate();
    }

    @Value.Immutable
    interface JsonEventTwo extends JsonEvent {
        int number();
    }

}
