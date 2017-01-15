package com.jirawat.immutable.json.complex;

import org.immutables.value.Value;

/**
 * User: juttayaya
 * Date: 1/10/17
 * Time: 8:44 AM
 */
@Value.Immutable
@JsonEventType
public interface JsonEventThree {
    String eventName();
}
