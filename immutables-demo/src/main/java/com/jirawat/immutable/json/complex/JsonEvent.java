package com.jirawat.immutable.json.complex;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author juttayaya
 */
@JsonEventType
interface JsonEvent {
    String name();
    BigDecimal size();

    @Value.Immutable
    interface JsonEventOne extends JsonEvent {
    }

    @Value.Immutable
    interface JsonEventTwo extends JsonEvent {
        int number();
    }

}
