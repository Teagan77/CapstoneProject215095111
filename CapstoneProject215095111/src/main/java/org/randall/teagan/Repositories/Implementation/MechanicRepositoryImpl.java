package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Repositories.RepositoryInterfaces.MechanicRepository;

import java.util.ArrayList;

public class MechanicRepositoryImpl implements MechanicRepository {

    private ArrayList<Mechanic> mechanics;

    private static MechanicRepositoryImpl mechanicRepositoryImpl = null;

    private MechanicRepositoryImpl(){
        this.mechanics = new ArrayList<>();
    }

    protected static MechanicRepositoryImpl getMechanicRepositoryImpl(){
        if(mechanicRepositoryImpl == null){
            mechanicRepositoryImpl = new MechanicRepositoryImpl();
        }
        return mechanicRepositoryImpl;
    }
    @Override
    public Mechanic create(Mechanic mechanic) {
        this.mechanics.add(mechanic);
        return mechanic;
    }

    @Override
    public Mechanic update(Mechanic mechanic) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < mechanics.size();i++) {

            if (mechanics.get(i).getMechanicID() == mechanic.getMechanicID()) {
                exists = true;
                index = i;
                mechanics.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent mechanic.");
        }

        mechanics.add(index, mechanic);
        return mechanic;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < mechanics.size();i++) {

            if (mechanics.get(i).getMechanicID() == id) {
                mechanics.remove(i);
            }
        }
    }

    @Override
    public Mechanic read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < mechanics.size();i++) {

            if (mechanics.get(i).getMechanicID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return mechanics.get(index);
    }

    @Override
    public ArrayList<Mechanic> getAll() {
        return mechanics;
    }

    @Override
    public void removeAll() {
        mechanics.removeAll(mechanics);
    }
}
