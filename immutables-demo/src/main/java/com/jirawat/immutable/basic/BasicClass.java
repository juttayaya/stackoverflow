package com.jirawat.immutable.basic;

import org.immutables.value.Value;

/**
 * Example of Basic Immutable Class
 * @author juttayaya
 */
@Value.Immutable
abstract class BasicClass {
    abstract String name();
}
