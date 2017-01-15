package com.jirawat.immutable.style;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author juttayaya
 */
public class SuffixNameExampleTest {
    private static final String FIELD_NAME="Test field name";
    private static final boolean FIELD_STATUS=false;
    private SuffixNameExampleImmutable testImmutable;

    @Before
    public void setUp() {
        this.testImmutable =
            SuffixNameExampleImmutable.builder().
            name(FIELD_NAME).
            status(FIELD_STATUS).
            build();
    }

    @Test
    public void testBuilder() {
        assertThat("Immutable Field Name incorrect",
        this.testImmutable.name(), is(FIELD_NAME));

        assertThat("Immutable Field Status incorrect",
        this.testImmutable.status(), is(FIELD_STATUS));
    }

    @Test(expected = IllegalStateException.class)
    public void testRequiredField() {
        SuffixNameExampleImmutable.builder().
        name(FIELD_NAME).
        build();
    }

}
