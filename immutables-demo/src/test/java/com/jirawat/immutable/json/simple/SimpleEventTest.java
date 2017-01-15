package com.jirawat.immutable.json.simple;

import com.jirawat.immutable.json.ImmutableJsonHelper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author juttayaya
 */
public class SimpleEventTest {
    private static final String FIELD_NAME="$";
    private static final BigDecimal FIELD_SIZE=BigDecimal.TEN;
    private static final String FIELD_DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss";
    private static final String FIELD_DATE_STRING="1999-12-31T23:59:59";
    private static final String JSON_RESULT="{\"name\":\"$\",\"size\":10,\"dateMs\":946702799000}";
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEventTest.class);

    private SimpleEvent testImmutable;

    @Before
    public void setUp()
    throws ParseException {
        this.testImmutable =
            ImmutableSimpleEvent.builder().
            name(FIELD_NAME).
            size(FIELD_SIZE).
            eventDate(createFieldDate()).
            build();
    }

    @Test
    public void testJSON()
    throws Exception {
        final String jsonString = ImmutableJsonHelper.toJSON(this.testImmutable);
        LOGGER.info("Event JSON string:" + jsonString);
        assertThat("Immutable JSON string incorrect",
            jsonString, is(JSON_RESULT));
        assertThat("Immutable Field Name is incorrect",
            this.testImmutable.name(), is(FIELD_NAME));
        assertThat("Immutable Field Size is incorrect",
            this.testImmutable.size(), is(FIELD_SIZE));
        assertThat("Immutable Field eventDate is incorrect",
            this.testImmutable.eventDate(), is(createFieldDate()));

    }

    /**
     * Test to show that Date field is not immutable by default
     */
    @Test
    public void testDateFieldCanBeChanged()
    throws ParseException {
        final Date eventDate = this.testImmutable.eventDate();
        eventDate.setTime(0L);
        LOGGER.info("testImmutable:" + this.testImmutable);
        assertThat("eventDate was not changed",
            this.testImmutable.eventDate(), is(not(createFieldDate())));

        final Date expectedDate = new Date();
        expectedDate.setTime(0L);
        assertThat("eventDate is incorrect",
            this.testImmutable.eventDate(), is((expectedDate)));

    }

    private Date createFieldDate()
    throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat(FIELD_DATE_FORMAT);

        return dateFormat.parse(FIELD_DATE_STRING);
    }
}
