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
typeImmutable = "*Immutable" // Change Immutable name to suffix
)
@interface SuffixNameStyle {
}
