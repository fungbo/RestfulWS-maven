package com.tw.common;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigurationTest {

    @Test
    public void should_get_property() {
        Boolean mode = Boolean.valueOf(Configuration.getProperty("test.mode"));
        assertThat(mode, is(true));

        String nullProperty = Configuration.getProperty("NotExisting");
        assertThat(nullProperty, nullValue());
    }
}