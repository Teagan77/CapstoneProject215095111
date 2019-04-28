package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.EmpAddress;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmpAddressRepository;
import java.util.ArrayList;

public class EmpAddressRepositoryImpl implements EmpAddressRepository {

    private ArrayList<EmpAddress> empAddresses;

    private static EmpAddressRepositoryImpl empAddressRepositoryImpl = null;

    private EmpAddressRepositoryImpl(){
        this.empAddresses = new ArrayList<>();
    }

    protected static EmpAddressRepositoryImpl getEmpAddressRepositoryImpl(){
        if(empAddressRepositoryImpl == null){
            empAddressRepositoryImpl = new EmpAddressRepositoryImpl();
        }
        return empAddressRepositoryImpl;
    }

    @Override
    public EmpAddress create(EmpAddress empAddress) {
        this.empAddresses.add(empAddress);
        return empAddress;
    }

    @Override
    public EmpAddress update(EmpAddress empAddress, EmpAddress updatedEmpAddress) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < empAddresses.size();i++) {

            if (empAddresses.get(i).hashCode() == empAddress.hashCode()) {
                exists = true;
                index = i;
                empAddresses.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent address.");
        }

        empAddresses.add(index, updatedEmpAddress);
        return empAddress;
    }

    @Override
    public void delete(EmpAddress empAddress) {
        if(empAddresses.contains(empAddress)){
            empAddresses.remove(empAddress);
        }
    }

    @Override
    public EmpAddress read(EmpAddress empAddress) {

        boolean exists = false;

        if(empAddresses.contains(empAddress)){
            exists = true;
            return empAddress;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<EmpAddress> getAll() {
        return empAddresses;
    }

    @Override
    public void removeAll() {
        empAddresses.removeAll(empAddresses);
    }
}
