package com.tw.common;

import com.tw.model.Address;
import com.tw.model.Customer;
import com.tw.model.PhoneNumber;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarshallerTest {
    private Marshaller<Customer> marshaller;
    private Customer customer;

    @Before
    public void setUp() throws JAXBException {
        marshaller = Marshaller.getInstance(Customer.class);

        Address address = new Address();
        address.setStreet("Jinye Road");
        address.setCity("Xi'an");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("62001");
        phoneNumber.setType("PRPD");
        List<Object> customerInfo = new ArrayList<Object>();
        customerInfo.add(address);
        customerInfo.add(phoneNumber);
        customerInfo.add("mike@gmail.com");
        customer = new Customer();
        customer.setCustomerInfo(customerInfo);
    }

    @Test
    public void should_marshal_object_to_string() throws JAXBException, IOException {
        String expectedString = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("customer-test.xml"));
        String actualString = marshaller.marshal(customer);

        assertThat(actualString, is(expectedString));
    }
}