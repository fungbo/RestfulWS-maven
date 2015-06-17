package com.tw.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TypeTest {
    @Test
    public void should_return_type() {
        Account.Type prepaid = Account.Type.fromName("PREPAID");
        assertThat(prepaid, is(Account.Type.PRPD));

        Account.Type postpaid = Account.Type.fromName("POSTPAID");
        assertThat(postpaid, is(Account.Type.POPD));

        Account.Type nullType = Account.Type.fromName("NotExisting");
        assertThat(nullType, nullValue());
    }
}