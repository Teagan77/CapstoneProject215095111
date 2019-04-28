package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Repositories.RepositoryInterfaces.IssueStaffRepository;

import java.util.ArrayList;

public class IssueStaffRepositoryImpl implements IssueStaffRepository {

    private ArrayList<IssueStaff> issueStaffs;

    private static IssueStaffRepositoryImpl issueStaffRepositoryImpl = null;

    private IssueStaffRepositoryImpl(){
        this.issueStaffs = new ArrayList<>();
    }

    protected static IssueStaffRepositoryImpl getIssueStaffRepositoryImpl(){
        if(issueStaffRepositoryImpl == null){
            issueStaffRepositoryImpl = new IssueStaffRepositoryImpl();
        }
        return issueStaffRepositoryImpl;
    }
    @Override
    public IssueStaff create(IssueStaff issueStaff) {
        this.issueStaffs.add(issueStaff);
        return issueStaff;
    }

    @Override
    public IssueStaff update(IssueStaff issueStaff) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < issueStaffs.size();i++) {

            if (issueStaffs.get(i).getIssuerNo() == issueStaff.getIssuerNo()) {
                exists = true;
                index = i;
                issueStaffs.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent issueStaff.");
        }

        issueStaffs.add(index, issueStaff);
        return issueStaff;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < issueStaffs.size();i++) {

            if (issueStaffs.get(i).getIssuerNo() == id) {
                issueStaffs.remove(i);
            }
        }
    }

    @Override
    public IssueStaff read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < issueStaffs.size();i++) {

            if (issueStaffs.get(i).getIssuerNo() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return issueStaffs.get(index);
    }

    @Override
    public ArrayList<IssueStaff> getAll() {
        return issueStaffs;
    }

    @Override
    public void removeAll() {
        issueStaffs.removeAll(issueStaffs);
    }

}
