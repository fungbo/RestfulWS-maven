/**
 * Specify Prefix Mappings with EclipseLink JAXB (MOXy)
 */

@XmlSchema(
        elementFormDefault = XmlNsForm.QUALIFIED,
        namespace = "http://www.thoughtworks.com/customer",
        xmlns={@XmlNs(prefix="", namespaceURI="http://www.thoughtworks.com/customer"),
                @XmlNs(prefix = "baidu", namespaceURI = "http://www.baidu.com")}
)
package com.tw.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
