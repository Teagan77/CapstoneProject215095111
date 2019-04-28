package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.EmpAddress;

import java.util.ArrayList;

public interface EmpAddressRepository<EmpAddress> {

    void removeAll();

    org.randall.teagan.Domain.Employee.EmpAddress update(org.randall.teagan.Domain.Employee.EmpAddress empAddress, org.randall.teagan.Domain.Employee.EmpAddress updatedEmpAddress);

    void delete(org.randall.teagan.Domain.Employee.EmpAddress empAddress);

    org.randall.teagan.Domain.Employee.EmpAddress read(org.randall.teagan.Domain.Employee.EmpAddress empAddress);
    ArrayList<EmpAddress> getAll();
    org.randall.teagan.Domain.Employee.EmpAddress create(org.randall.teagan.Domain.Employee.EmpAddress o);
}
