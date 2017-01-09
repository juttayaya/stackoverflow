package com.jirawat.immutable.domain;

import org.immutables.value.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: juttayaya
 * Date: 12/20/16
 * Time: 9:19 AM
 */
@Value.Immutable
public abstract class MoneyTransfer implements Serializable {
    private static final long serialVersionUID = -123;

    public abstract String currencyType();
    public abstract BigDecimal amount();
    public abstract Date sendDate();
}
