package com.tw.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static String marshal(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "marshal error";
        }
    }

    public static <T> T unmarshal(InputStream inputStream, Class<T> clazz) throws IOException {
        return mapper.readValue(inputStream, clazz);
    }
}
