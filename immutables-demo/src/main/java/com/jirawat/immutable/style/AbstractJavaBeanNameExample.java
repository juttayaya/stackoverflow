package com.jirawat.immutable.style;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author juttayaya
 */
@Value.Immutable
@JavaBeanNameStyle
interface AbstractJavaBeanNameExample {
    String getName();
    boolean isStatus();
}
