package com.tw.common;

import com.tw.model.Address;
import com.tw.model.Customer;
import com.tw.model.PhoneNumber;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnmarshallerTest {
    private InputStream inputStream;
    private Unmarshaller<Customer> unmarshaller;
    private Customer expectedCustomer;

    @Before
    public void setUp() throws JAXBException {
        inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("customer-test.xml");
        unmarshaller = Unmarshaller.getInstance(Customer.class);

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
        expectedCustomer = new Customer();
        expectedCustomer.setCustomerInfo(customerInfo);
    }

    @Test
    public void should_unmarshal_string_to_object() throws JAXBException {
        Customer actualCustomer = unmarshaller.unmarshal(inputStream);

        Address actualAddress = (Address)actualCustomer.getCustomerInfo().get(0);
        Address expectedAddress = (Address)expectedCustomer.getCustomerInfo().get(0);
        assertThat(actualAddress.getCity(), is(expectedAddress.getCity()));
        assertThat(actualAddress.getStreet(), is(expectedAddress.getStreet()));

        PhoneNumber actualPhoneNumber = (PhoneNumber) actualCustomer.getCustomerInfo().get(1);
        PhoneNumber expectedPhoneNumber = (PhoneNumber) expectedCustomer.getCustomerInfo().get(1);
        assertThat(actualPhoneNumber.getNumber(), is(expectedPhoneNumber.getNumber()));
        assertThat(actualPhoneNumber.getType(), is(expectedPhoneNumber.getType()));

        String actualEmail = (String) actualCustomer.getCustomerInfo().get(2);
        String expectedEmail = (String) expectedCustomer.getCustomerInfo().get(2);
        assertThat(actualEmail, is(expectedEmail));
    }
}