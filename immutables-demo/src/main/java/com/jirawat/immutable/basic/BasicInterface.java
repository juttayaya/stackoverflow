package com.jirawat.immutable.basic;

import org.immutables.value.Value;

/**
 * Example of a basic Immutable interface
 * @author juttayaya
 */
@Value.Immutable
public interface BasicInterface {
    String name();
}
