package com.tw.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class Unmarshaller<T> {
    private final javax.xml.bind.Unmarshaller unmarshaller;

    public static <W> Unmarshaller getInstance(Class<W> clazz) throws JAXBException {
        return new Unmarshaller(clazz);
    }

    public T unmarshal(InputStream inputStream) throws JAXBException {
        return (T) unmarshaller.unmarshal(inputStream);
    }


    private Unmarshaller(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
