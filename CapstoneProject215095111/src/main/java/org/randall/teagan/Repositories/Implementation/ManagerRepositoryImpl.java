package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Repositories.RepositoryInterfaces.ManagerRepository;

import java.util.ArrayList;

public class ManagerRepositoryImpl implements ManagerRepository {

    private ArrayList<Manager> managers;
    private static ManagerRepositoryImpl managerRepositoryImpl = null;

    private ManagerRepositoryImpl(){
        this.managers = new ArrayList<>();
    }

    protected static ManagerRepositoryImpl getManagerRepositoryImpl(){
        if(managerRepositoryImpl == null){
            managerRepositoryImpl = new ManagerRepositoryImpl();
        }
        return managerRepositoryImpl;
    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < managers.size();i++) {

            if (managers.get(i).getManagerID() == manager.getManagerID()) {
                exists = true;
                index = i;
                managers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent manager.");
        }

        managers.add(index, manager);
        return manager;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < managers.size();i++) {

            if (managers.get(i).getManagerID() == id) {
                managers.remove(i);
            }
        }
    }

    @Override
    public Manager read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < managers.size();i++) {

            if (managers.get(i).getManagerID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return managers.get(index);
    }

    @Override
    public ArrayList<Manager> getAll() {
        return managers;
    }

    @Override
    public void removeAll() {
        managers.removeAll(managers);
    }
}
