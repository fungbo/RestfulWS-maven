package com.tw.jaxb;

import com.tw.common.Marshaller;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class BeansTest {
    @Test
    public void should_be_marshalled() throws JAXBException {
        ComponentScan componentScan = new ComponentScan();
        componentScan.setBasePackage("com.tw");
        componentScan.setValue("");
        Beans beans = new Beans();
        beans.setComponentScan(componentScan);
        beans.setAnnotationDriven("");

        Marshaller<Beans> marshaller = Marshaller.getInstance(Beans.class);
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_SCHEMA_LOCATION, "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd "
                + "http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd "
                + "http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd");

        String marshal = marshaller.marshal(beans);

        System.out.println(marshal);

    }
}