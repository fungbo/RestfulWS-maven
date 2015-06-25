package com.tw.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class ComponentScan {
    @XmlAttribute(name = "base-package")
    private String basePackage;
    @XmlValue
    private String value;

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
