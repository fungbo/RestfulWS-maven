package com.tw.common;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

public class JAXBMarshaller<T> {
    private Marshaller marshaller;

    public static <W> JAXBMarshaller getInstance(Class<W> clazz) throws JAXBException {
        return new JAXBMarshaller(clazz);
    }

    public String marshal(T object) throws JAXBException {
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, getXmlSerializer(writer));
        return writer.toString();
    }

    public void setProperty(String name, String value) throws PropertyException {
        marshaller.setProperty(name, value);
    }

    private XMLSerializer getXmlSerializer(StringWriter writer) {
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setCDataElements(new String[]{"http://www.thoughtworks.com/customer^email",
                "http://www.thoughtworks.com/customer^street"});
        outputFormat.setIndenting(true);
        return new XMLSerializer(writer, outputFormat);
    }

    private JAXBMarshaller(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//        marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new CustomerNamespaceMapper());
    }
}
