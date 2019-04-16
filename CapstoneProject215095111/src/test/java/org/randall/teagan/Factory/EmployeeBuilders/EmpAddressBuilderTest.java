package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmpAddress;

import static org.junit.Assert.*;

public class EmpAddressBuilderTest {

    @Test
    public void getEmpAddress() {
        String physicalAddr = "1 Gore Street, DeZonnebloem";
        int postalAddr = 4210;
        int postalCode = 4280;

        EmpAddress firstAddr = EmpAddressBuilder.getEmpAddress(physicalAddr, postalAddr, postalCode);

        System.out.println(firstAddr);
        Assert.assertNotNull(firstAddr.getPhysicalAddr());
    }
}