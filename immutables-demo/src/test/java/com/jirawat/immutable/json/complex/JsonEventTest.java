package com.jirawat.immutable.json.complex;

import com.jirawat.immutable.json.ImmutableJsonHelper;
import com.jirawat.immutable.json.simple.ImmutableSimpleEvent;
import com.jirawat.immutable.json.simple.SimpleEvent;
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
public class JsonEventTest {
    private static final String FIELD_NAME="$";
    private static final BigDecimal FIELD_SIZE=BigDecimal.TEN;
    private static final BigDecimal FIELD_SIZE_THREE=BigDecimal.ONE;
    private static final String FIELD_DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss";
    private static final String FIELD_DATE_STRING="1999-12-31T23:59:59";
    private static final String JSON_RESULT_ONE="{\"name\":\"$\",\"size\":10}";
    private static final String JSON_RESULT_THREE="{\"dateMs\":946702799000,\"name\":\"$\",\"size\":1}";
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonEventTest.class);

    private JsonEvent jsonEventOne;
    private JsonEventThree jsonEventThree;
    @Before
    public void setUp()
    throws ParseException {
        this.jsonEventOne =
            ImmutableJsonEventOne.builder().
            name(FIELD_NAME).
            size(FIELD_SIZE).
            build();

        this.jsonEventThree =
            ImmutableJsonEventThree.builder().
            name(FIELD_NAME).
            size(FIELD_SIZE_THREE).
            eventDate(createFieldDate()).
            build();

    }

    @Test
    public void testJSONOne()
    throws Exception {
        final String jsonString = ImmutableJsonHelper.toJSON(this.jsonEventOne);
        LOGGER.info("JsonEventOne string:" + jsonString);
        assertThat("Immutable JSON string incorrect",
            jsonString, is(JSON_RESULT_ONE));
        assertThat("Immutable Field Name is incorrect",
            this.jsonEventOne.name(), is(FIELD_NAME));
        assertThat("Immutable Field Size is incorrect",
            this.jsonEventOne.size(), is(FIELD_SIZE));
    }

    @Test
    public void testJSONThree()
    throws Exception {
        final String jsonString = ImmutableJsonHelper.toJSON(this.jsonEventThree);
        LOGGER.info("JsonEventThree string:" + jsonString);
        assertThat("Immutable JSON string incorrect",
            jsonString, is(JSON_RESULT_THREE));
        assertThat("Immutable Field Name is incorrect",
            this.jsonEventThree.name(), is(FIELD_NAME));
        assertThat("Immutable Field Size is incorrect",
            this.jsonEventThree.size(), is(FIELD_SIZE_THREE));
        assertThat("Immutable Field eventDate is incorrect",
            this.jsonEventThree.eventDate(), is(createFieldDate()));

    }

    private Date createFieldDate()
    throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat(FIELD_DATE_FORMAT);

        return dateFormat.parse(FIELD_DATE_STRING);
    }
}
