package com.tw.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "MtsmsData")
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
