package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface IssueStaffRepository extends Repository<IssueStaff, String> {

    void removeAll();
    ArrayList<IssueStaff> getAll();
}
