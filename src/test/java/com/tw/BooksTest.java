package com.tw;

import com.tw.common.JsonUtils;
import org.junit.Test;

import java.io.IOException;

public class BooksTest {
    @Test
    public void should_Name() throws IOException {
//        String bookList = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("Books.json"));

        Books books = JsonUtils.unmarshal(Thread.currentThread().getContextClassLoader().getResourceAsStream("app/Books.json"), Books.class);




    }
}