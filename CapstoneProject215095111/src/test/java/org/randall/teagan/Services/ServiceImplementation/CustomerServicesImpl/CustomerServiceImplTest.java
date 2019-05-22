package org.randall.teagan.Services.ServiceImplementation.CustomerServicesImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;
import org.randall.teagan.Repositories.Implementation.CustomerRepositoryImpl.CustomerRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceImplTest {

    private CustomerRepositoryImpl customerRepositoryImpl;
    private Customer firstCust;
    private Membership membership;
    private MemberType memberType;

    private Customer getSaved(){
        ListIterator<Customer> listItr = this.customerRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.customerRepositoryImpl = CustomerRepositoryImpl.getCustomerRepositoryImpl();
        this.memberType = MemTypeBuilder.getMemberType("10211", "Full-Time");
        this.membership = MembershipBuilder.getMembership(memberType, "10111");
        this.firstCust = CustBuilder.getCustomer("215095111", "Jeff", "Saunders", 25, "0729865543",  50.00, "Male", membership);
    }

    @Test
    public void a_create() {
        Customer createdCust = this.customerRepositoryImpl.create(this.firstCust);
        System.out.println("In create, created = " + createdCust);
        Assert.assertNotNull(createdCust);
        Assert.assertSame(createdCust, this.firstCust);
    }

    @Test
    public void c_update() {
        String newSurname = "Williams";
        Customer updatedCust = new Customer.Builder().copy(getSaved()).custLName(newSurname).build();
        System.out.println("In update, updated = " + updatedCust);
        this.customerRepositoryImpl.update(updatedCust);
        Assert.assertSame(newSurname, updatedCust.getCustLastName());
    }

    @Test
    public void e_delete() {
        Customer savedCust = getSaved();
        this.customerRepositoryImpl.delete(savedCust.getCustId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Customer savedCust = getSaved();
        Customer readCust = this.customerRepositoryImpl.read(savedCust.getCustId());
        System.out.println("In read, read = "+ readCust);
        Assert.assertSame(readCust, savedCust);
    }

    @Test
    public void d_getAll() {
        ArrayList<Customer> customers = this.customerRepositoryImpl.getAll();
        System.out.println("In getall, all = " + customers);
    }
}