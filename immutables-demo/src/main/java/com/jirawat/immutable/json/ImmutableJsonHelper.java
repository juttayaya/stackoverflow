package com.jirawat.immutable.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jirawat.immutable.json.simple.SimpleEvent;

/**
 * User: juttayaya
 * Date: 12/20/16
 * Time: 9:45 AM
 */
public final class ImmutableJsonHelper {
    private static final ObjectMapper jsonObjectMapper = new ObjectMapper();

    private ImmutableJsonHelper() {}

    public static String toJSON(final SimpleEvent moneyTransfer)
    throws Exception {
         return jsonObjectMapper.writeValueAsString(moneyTransfer);
    }
}
