package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;
import org.randall.teagan.Factory.TripBuilders.PassengerBuilder;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.PassengerRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PassengerServiceImplTest {

    private PassengerRepositoryImpl passengerRepositoryImpl;
    private Customer firstCust;
    private Customer secondCust;
    private Membership membership;
    private MemberType memberType;
    private Passenger firstPassenger;
    private Passenger secondPasseger;

    private Passenger getSaved(){
        ListIterator<Passenger> listItr = this.passengerRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.passengerRepositoryImpl = PassengerRepositoryImpl.getPassengerRepositoryImpl();
        this.memberType = MemTypeBuilder.getMemberType("10211", "Full-Time");
        this.membership = MembershipBuilder.getMembership(memberType, "10111");
        this.firstCust = CustBuilder.getCustomer("215095111", "Jeff", "Saunders",25 , "0729865543", 50.00, "Male", membership);
        this.secondCust = CustBuilder.getCustomer("215095111", "Jahsey", "Stevens",23 , "0734771369",75.00, "Male", membership);
        this.firstPassenger = PassengerBuilder.getPassenger(firstCust);
        this.secondPasseger = PassengerBuilder.getPassenger(secondCust);
    }

    @Test
    public void a_create() {
        Passenger createdPassenger = this.passengerRepositoryImpl.create(this.firstPassenger);
        System.out.println("In create, created = " + createdPassenger);
        Assert.assertNotNull(createdPassenger);
        Assert.assertSame(createdPassenger, this.firstPassenger);
    }

    @Test
    public void c_update() {
        this.passengerRepositoryImpl.update(secondPasseger);
        System.out.println("In update, updated = " + secondPasseger);
        Assert.assertNotEquals(firstPassenger,secondPasseger);
    }

    @Test
    public void e_delete() {
        Passenger savedPassenger = getSaved();
        this.passengerRepositoryImpl.delete(savedPassenger.getPassenger().getCustId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Passenger savedPassenger = getSaved();
        Passenger readPassenger = this.passengerRepositoryImpl.read(savedPassenger.getPassenger().getCustId());
        System.out.println("In read, read = "+ readPassenger);
        Assert.assertSame(readPassenger, savedPassenger);
    }

    @Test
    public void d_getAll() {
        ArrayList<Passenger> passengers = this.passengerRepositoryImpl.getAll();
        System.out.println("In getall, all = " + passengers);
    }
}