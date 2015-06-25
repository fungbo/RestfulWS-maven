package com.tw.jaxb;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class Beans {
    @XmlElement(name = "component-scan", namespace = "http://www.springframework.org/schema/context")
    private ComponentScan componentScan;
    @XmlElement(name = "annotation-driven", namespace = "http://www.springframework.org/schema/mvc")
    private String annotationDriven;

    public void setComponentScan(ComponentScan componentScan) {
        this.componentScan = componentScan;
    }

    public void setAnnotationDriven(String annotationDriven) {
        this.annotationDriven = annotationDriven;
    }
}
