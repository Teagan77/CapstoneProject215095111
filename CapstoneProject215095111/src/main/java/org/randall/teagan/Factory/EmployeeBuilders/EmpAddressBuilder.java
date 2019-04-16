package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.EmpAddress;

public class EmpAddressBuilder {

    public static EmpAddress getEmpAddress(String physicalAddr, int postalAddr, int postalCode) {
        return new EmpAddress.AddrBuilder()
                .physicalAddr(physicalAddr)
                .postalAddr(postalAddr)
                .postalCode(postalCode)
                .build();
    }
}
