@XmlSchema(
        elementFormDefault = XmlNsForm.QUALIFIED,
        namespace = "http://www.springframework.org/schema/beans",
        xmlns={@XmlNs(prefix="", namespaceURI="http://www.springframework.org/schema/beans"),
        @XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),
        @XmlNs(prefix = "context", namespaceURI = "http://www.springframework.org/schema/context"),
        @XmlNs(prefix = "mvc", namespaceURI = "http://www.springframework.org/schema/mvc")}
)

package com.tw.jaxb;

import javax.xml.bind.annotation.XmlNs;
        import javax.xml.bind.annotation.XmlNsForm;
        import javax.xml.bind.annotation.XmlSchema;
