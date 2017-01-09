package com.jirawat.immutable.domain;

import com.jirawat.immutable.json.ImmutableJsonHelper;
import com.jirawat.immutable.json.simple.ImmutableSimpleEvent;
import com.jirawat.immutable.json.simple.SimpleEvent;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

/**
 * User: juttayaya
 * Date: 12/20/16
 * Time: 9:28 AM
 */
public class MoneyTransferTest {
    @Test
    public void testMoneyTransferBuilder() {
         MoneyTransfer moneyTransfer =
             ImmutableMoneyTransfer.builder().
                 currencyType("$").
                 amount(BigDecimal.TEN).
                 sendDate(new Date()).
                 build();

         System.out.println("Money Transfer : " + moneyTransfer);
         Assert.assertThat(moneyTransfer.amount(),is(BigDecimal.TEN));
    }

    // Immutable value object not working?
    @Test
    public void testMoneyTransferImmutable() {
        MoneyTransfer moneyTransfer =
            ImmutableMoneyTransfer.builder().
                currencyType("$").
                amount(BigDecimal.TEN).
                sendDate(new Date()).
                build();

        System.out.println("Money Transfer : " + moneyTransfer);

        final Date sendDate = moneyTransfer.sendDate();
        sendDate.setTime(System.currentTimeMillis() - 1000000);
        System.out.println("Money Transfer After : " + moneyTransfer);
    }


}
