package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmpAddress;
import org.randall.teagan.Factory.EmployeeBuilders.EmpAddressBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmpAddressRepositoryImplTest {
    
    private EmpAddressRepositoryImpl empAddressRepositoryImpl;
    
    EmpAddressBuilder empAddressBuilder = new EmpAddressBuilder();

    String physicalAddr = "1 Gore Street, DeZonnebloem";
    int postalAddr = 4210;
    int postalCode = 4280;
    
    int updatedPostalCode = 8903;
    
    String physicalAddr2 = "2 Kings Street, District 6";
    int postalAddr2 = 4224;
    int postalCode2 = 5467;
    
   EmpAddress firstAddress = empAddressBuilder.getEmpAddress(physicalAddr,postalAddr,postalCode);
   EmpAddress updatedFirstAddress = empAddressBuilder.getEmpAddress(physicalAddr, postalAddr, updatedPostalCode);
   EmpAddress secondAddress = empAddressBuilder.getEmpAddress(physicalAddr2, postalAddr2, postalCode2);

    @Before
    public void setUp() throws Exception {
        this.empAddressRepositoryImpl = EmpAddressRepositoryImpl.getEmpAddressRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstAddress.hashCode(), this.empAddressRepositoryImpl.create(firstAddress).hashCode());
        this.empAddressRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.empAddressRepositoryImpl.create(firstAddress);
        this.empAddressRepositoryImpl.update(firstAddress,updatedFirstAddress);
        Assert.assertEquals(8903, this.empAddressRepositoryImpl.read(updatedFirstAddress).getPostalCode());
        this.empAddressRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.empAddressRepositoryImpl.create(firstAddress);
        this.empAddressRepositoryImpl.create(secondAddress);
        this.empAddressRepositoryImpl.delete(firstAddress);

        assertEquals(null, this.empAddressRepositoryImpl.read(firstAddress));
        this.empAddressRepositoryImpl.removeAll();
    }


    @Test
    public void read() {
        this.empAddressRepositoryImpl.create(firstAddress);
        assertEquals(true, this.empAddressRepositoryImpl.read(firstAddress) instanceof EmpAddress);
        System.out.println(this.empAddressRepositoryImpl.read(firstAddress));
        this.empAddressRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.empAddressRepositoryImpl.create(firstAddress);
        ArrayList<EmpAddress> empAddresses = this.empAddressRepositoryImpl.getAll();
        assertEquals(1, empAddresses.size());
        this.empAddressRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.empAddressRepositoryImpl.create(firstAddress);
        ArrayList<EmpAddress> customer = this.empAddressRepositoryImpl.getAll();
        this.empAddressRepositoryImpl.removeAll();
        assertEquals( 0,customer.size());
    }
}