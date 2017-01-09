package com.jirawat.immutable.json.simple;

import com.jirawat.immutable.json.ImmutableJsonHelper;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: juttayaya
 * Date: 12/31/16
 * Time: 12:16 PM
 */
public class SimpleEventTest {
    @Test
    public void testMoneyTransferJSON()
    throws Exception {
        SimpleEvent moneyTransfer =
            ImmutableSimpleEvent.builder().
                name("$").
                size(BigDecimal.TEN).
                eventDate(new Date()).
                build();

        final String jsonMoney = ImmutableJsonHelper.toJSON(moneyTransfer);
        System.out.println("Money Transfer JSON:");
        System.out.println(jsonMoney);

    }

    @Test
    public void testSendMoneyEventImmutable() {
        SimpleEvent moneyTransfer =
            ImmutableSimpleEvent.builder().
                name("$").
                size(BigDecimal.TEN).
                eventDate(new Date()).
                build();

        System.out.println("JSON Money Transfer : " + moneyTransfer);

        final Date sendDate = moneyTransfer.eventDate();
        sendDate.setTime(System.currentTimeMillis() - 1000000);
        System.out.println("JSON Money Transfer After : " + moneyTransfer);
    }

}
