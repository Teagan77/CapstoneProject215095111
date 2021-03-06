package org.randall.teagan.Repositories.Implementation.CustomerRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Repositories.Implementation.CustomerRepositoryImpl.CustomerRepositoryImpl;

import java.util.ArrayList;

public class CustomerRepositoryImplTest {

    private CustomerRepositoryImpl custRepository;

    String updatedName = "Jeffrey";

    String name = "Teagan";
    String surname = "Randall";
    String phone = "0734771369";
    int age = 22;
    String id = "215095111";

    String name2 = "DK";
    String surname2 = "Basson";
    String phone2 = "0729871365";
    int age2 = 21;
    String id2 = "2161513428";

    CustBuilder custBuilder = new CustBuilder();

    Customer updatedFirstCust = custBuilder.getCustomer(id, updatedName, surname, age, phone);
    Customer firstCust = custBuilder.getCustomer(id, name, surname, age, phone);
    Customer secondCust = custBuilder.getCustomer(id2, name2, surname2, age2, phone2);

    @Before
    public void setUp() throws Exception {
        this.custRepository = CustomerRepositoryImpl.getCustomerRepositoryImpl();
    }
    @Test
    public void create() {
        //Assert.assertEquals(true, this.custRepository.create(firstCust) instanceof Customer);
        Assert.assertEquals(firstCust.hashCode(), this.custRepository.create(firstCust).hashCode());
        this.custRepository.removeAll();
    }

    @Test
    public void update() {
        this.custRepository.create(firstCust);
        this.custRepository.update(updatedFirstCust);
        Assert.assertEquals("Jeffrey", this.custRepository.read(updatedFirstCust.getcustomerID()).getCustName());
        this.custRepository.removeAll();
    }

    @Test
    public void delete() {
        this.custRepository.create(firstCust);
        this.custRepository.create(secondCust);
        this.custRepository.delete(firstCust.getcustomerID());

        Assert.assertEquals(null, this.custRepository.read(firstCust.getcustomerID()));
        this.custRepository.removeAll();
    }

    @Test
    public void read() {
        this.custRepository.create(firstCust);
        Assert.assertEquals(true, this.custRepository.read(firstCust.getcustomerID()) instanceof Customer);
        System.out.println(this.custRepository.read(firstCust.getcustomerID()));
        this.custRepository.removeAll();
    }

    @Test
    public void getAll() {
        this.custRepository.create(firstCust);
        ArrayList<Customer> customer = this.custRepository.getAll();
        Assert.assertEquals(1, customer.size());
        this.custRepository.removeAll();
    }

    @Test
    public void removeAll() {
        this.custRepository.create(firstCust);
        ArrayList<Customer> customer = this.custRepository.getAll();
        this.custRepository.removeAll();
        Assert.assertEquals( 0,customer.size());
    }
}