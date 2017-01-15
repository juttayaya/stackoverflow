package com.jirawat.immutable.style;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author juttayaya
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Value.Style(
    get = {"get*", "is*"},  // Detect 'get' and 'is' prefixes in accessor methods
    init = "set*"  // Builder initialization methods will have 'set' prefix
)
@interface GetterSetterStyle {
}
