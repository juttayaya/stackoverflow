package com.jirawat.immutable.json.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: juttayaya
 * Date: 12/31/16
 * Time: 10:08 AM
 */
@Value.Immutable
@JsonSerialize(as = ImmutableSimpleEvent.class)
@JsonDeserialize(as = ImmutableSimpleEvent.class)
public interface SimpleEvent {
    String name();
    BigDecimal size();
    @JsonProperty("dateMs") Date eventDate();
}
