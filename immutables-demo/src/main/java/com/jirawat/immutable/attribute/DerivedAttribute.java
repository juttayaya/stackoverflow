package com.jirawat.immutable.attribute;

import org.immutables.value.Value;

/**
 * @author juttayaya
 */
@Value.Immutable
public abstract class DerivedAttribute {
    public abstract String firstName();
    public abstract String lastName();
    @Value.Derived
    public String fullName() {
        return firstName() + " " + lastName();
    }
}
