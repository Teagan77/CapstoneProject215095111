package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.EmpContact;

import java.util.ArrayList;

public interface EmpContactRepository {

    void removeAll();

    org.randall.teagan.Domain.Employee.EmpContact update(org.randall.teagan.Domain.Employee.EmpContact empContact, org.randall.teagan.Domain.Employee.EmpContact updatedEmpContact);
    void delete(org.randall.teagan.Domain.Employee.EmpContact empContact);
    org.randall.teagan.Domain.Employee.EmpContact read(org.randall.teagan.Domain.Employee.EmpContact empContact);
    ArrayList<EmpContact> getAll();
    org.randall.teagan.Domain.Employee.EmpContact create(org.randall.teagan.Domain.Employee.EmpContact empContact);
}
