package com.tw.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JAXBMarshaller<T> {
    private Marshaller marshaller;

    public static <W> JAXBMarshaller getInstance(Class<W> clazz) throws JAXBException {
        return new JAXBMarshaller(clazz);
    }

    public String marshal(T object) throws JAXBException {
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    private JAXBMarshaller(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
