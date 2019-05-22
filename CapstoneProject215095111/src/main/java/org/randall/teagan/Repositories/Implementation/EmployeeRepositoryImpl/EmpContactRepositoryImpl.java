package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl;

import org.randall.teagan.Domain.Employee.EmpContact;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface.EmpContactRepository;

import java.util.ArrayList;

public class EmpContactRepositoryImpl implements EmpContactRepository {

    private ArrayList<EmpContact> empContacts;
    private static EmpContactRepositoryImpl empContactRepositoryImpl = null;

    private EmpContactRepositoryImpl(){
        this.empContacts = new ArrayList<>();
    }

    public static EmpContactRepositoryImpl getEmpContactRepositoryImpl(){
        if(empContactRepositoryImpl == null){
            empContactRepositoryImpl = new EmpContactRepositoryImpl();
        }
        return empContactRepositoryImpl;
    }

    @Override
    public EmpContact create(EmpContact empContact) {
        this.empContacts.add(empContact);
        return empContact;
    }

    @Override
    public EmpContact update(EmpContact empContact, EmpContact updatedEmpContact) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < empContacts.size();i++) {

            if (empContacts.get(i).hashCode() == empContact.hashCode()) {
                exists = true;
                index = i;
                empContacts.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent contact.");
        }

        empContacts.add(index, updatedEmpContact);
        return empContact;
    }

    @Override
    public void delete(EmpContact empContact) {
        if(empContacts.contains(empContact)){
            empContacts.remove(empContact);
        }
    }

    @Override
    public EmpContact read(EmpContact empContact) {
        boolean exists = false;

        if(empContacts.contains(empContact)){
            exists = true;
            return empContact;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<EmpContact> getAll() {
        return empContacts;
    }

    @Override
    public void removeAll() {
        empContacts.removeAll(empContacts);
    }
}
