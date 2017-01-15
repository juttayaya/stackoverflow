package com.jirawat.immutable.style;

import org.immutables.value.Value;

/**
 * @author juttayaya
 */
@Value.Immutable
@GetterSetterStyle
interface GetterSetterExample {
    String getName();
    boolean isStatus();
}
