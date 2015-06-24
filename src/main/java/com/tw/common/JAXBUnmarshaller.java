package com.tw.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class JAXBUnmarshaller<T> {
    private final Unmarshaller unmarshaller;

    public static <W> JAXBUnmarshaller getInstance(Class<W> clazz) throws JAXBException {
        return new JAXBUnmarshaller(clazz);
    }

    public T unmarshal(InputStream inputStream) throws JAXBException {
        return (T) unmarshaller.unmarshal(inputStream);
    }


    private JAXBUnmarshaller(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
