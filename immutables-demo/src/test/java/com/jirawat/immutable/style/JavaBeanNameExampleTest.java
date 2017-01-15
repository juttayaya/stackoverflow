package com.jirawat.immutable.style;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author juttayaya
 */
public class JavaBeanNameExampleTest {
    private static final String FIELD_NAME="Test field name";
    private static final boolean FIELD_STATUS=false;
    private JavaBeanNameExample testImmutable;

    @Before
    public void setUp() {
        this.testImmutable =
            new JavaBeanNameExample.Builder().
            setName(FIELD_NAME).
            setStatus(FIELD_STATUS).
            create();
    }

    @Test
    public void testBuilder() {
        assertThat("Immutable Field Name incorrect",
        this.testImmutable.getName(), is(FIELD_NAME));

        assertThat("Immutable Field Status incorrect",
        this.testImmutable.isStatus(), is(FIELD_STATUS));
    }

    @Test(expected = IllegalStateException.class)
    public void testRequiredField() {
        ImmutableGetterSetterExample.builder().
        setName(FIELD_NAME).
        build();
    }

}
