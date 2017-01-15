package com.jirawat.immutable.basic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author juttayaya
 */
public class BasicClassTest {
    private static final String FIELD_NAME = "Test Builder Name";
    private BasicClass testBasicImmutable;

    @Before
    public void setUp() {
        this.testBasicImmutable =
            ImmutableBasicClass.builder().
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
        final BasicClass basicImmutable =
            ImmutableBasicClass.builder().
            name(FIELD_NAME).
            build();

        assertThat("Immutables not equal",
            basicImmutable, equalTo(testBasicImmutable));
    }

    @Test(expected = IllegalStateException.class)
    public void testRequiredField() {
        ImmutableBasicClass.builder().
            build();

    }

}
