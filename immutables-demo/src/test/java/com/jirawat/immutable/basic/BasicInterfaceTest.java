package com.jirawat.immutable.basic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author juttayaya
 */
public class BasicInterfaceTest {
    private static final String FIELD_NAME = "Test Builder Name";
    private BasicInterface testBasicImmutable;

    @Before
    public void setUp() {
        this.testBasicImmutable =
            ImmutableBasicInterface.builder().
            name(FIELD_NAME).
            build();
    }

    @Test
    public void testImmutableBuilder() {
        assertThat("Immutable Field Name is incorrect",
            this.testBasicImmutable.name(), is(FIELD_NAME));
    }

    @Test
    public void testEquality() {
        final BasicInterface basicImmutable =
            ImmutableBasicInterface.builder().
            name(FIELD_NAME).
            build();

        assertThat("Immutables not equal",
            basicImmutable, equalTo(testBasicImmutable));
    }

    @Test(expected = IllegalStateException.class)
    public void testRequiredField() {
        ImmutableBasicInterface.builder().
            build();

    }

}
