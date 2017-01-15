package com.jirawat.immutable.style;

import org.immutables.value.Value;

/**
 * @author juttayaya
 */
@Value.Immutable
@SuffixNameStyle
interface SuffixNameExample {
    String name();
    boolean status();
}
