package com.jirawat.immutable.basic;

import org.immutables.value.Value;

/**
 * Example of basic Immutable Interface Annotation
 * @author juttayaya
 */
@Value.Immutable
public @interface BasicInterfaceAnnotation {
    String name();
}
