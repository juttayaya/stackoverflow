package com.jirawat.immutable.attribute;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * @author juttayaya
 */
@Value.Immutable
public interface OptionalAttribute {
    String firstName();
    String lastName();
    Optional<String> middleName();

}
