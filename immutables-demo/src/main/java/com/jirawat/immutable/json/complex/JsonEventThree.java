package com.jirawat.immutable.json.complex;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.util.Date;

/**
 * User: juttayaya
 * Date: 1/10/17
 * Time: 8:44 AM
 */
@Value.Immutable
@JsonEventType
interface JsonEventThree extends JsonEvent {
    @JsonProperty("dateMs") Date eventDate();
}
