package com.tw.common;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

public class Marshaller<T> {
    private javax.xml.bind.Marshaller marshaller;

    public static <W> Marshaller getInstance(Class<W> clazz) throws JAXBException {
        return new Marshaller(clazz);
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

    private Marshaller(Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
//        marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new CustomerNamespaceMapper());
    }
}
