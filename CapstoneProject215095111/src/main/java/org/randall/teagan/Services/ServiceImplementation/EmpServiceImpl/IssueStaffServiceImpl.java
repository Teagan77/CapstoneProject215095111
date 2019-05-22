package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.IssueStaffRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.IssueStaffServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("IssueStaffServiceImpl")
public class IssueStaffServiceImpl implements IssueStaffServiceInterface {

    @Autowired
    @Qualifier("IssueStaffRepository")
    private IssueStaffRepositoryImpl issueStaffRepositoryImpl;

    @Override
    public IssueStaff create(IssueStaff issueStaff) {
        return issueStaffRepositoryImpl.create(issueStaff);
    }

    @Override
    public IssueStaff update(IssueStaff issueStaff) {
        return issueStaffRepositoryImpl.update(issueStaff);
    }

    @Override
    public void delete(String staffId) {
        issueStaffRepositoryImpl.delete(staffId);
    }

    @Override
    public IssueStaff read(String staffId) {
        return issueStaffRepositoryImpl.read(staffId);
    }

    @Override
    public ArrayList<IssueStaff> getAll() {
        return issueStaffRepositoryImpl.getAll();
    }
}
