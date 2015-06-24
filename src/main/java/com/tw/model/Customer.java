package com.tw.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
   This is not a best practice. Just an example to show us how to use @XmlElements
 */

@XmlRootElement(name = "MtsmsData")
//@XmlRootElement(name = "MtsmsData", namespace="http://www.thoughtworks.com"))
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    @XmlElements({@XmlElement(name = "address", type = Address.class),
            @XmlElement(name = "phone-number", type = PhoneNumber.class),
            @XmlElement(name = "email", type = String.class)})
    private List<Object> customerInfo;

    public List<Object> getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(List<Object> customerInfo) {
        this.customerInfo = customerInfo;
    }
}
