package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.MiniBusRepository;

import java.util.ArrayList;

public class MinibusRepositoryImpl implements MiniBusRepository {

    private ArrayList<Minibus> minibuses;

    private static MinibusRepositoryImpl minibusRepositoryImpl = null;

    private MinibusRepositoryImpl(){
        this.minibuses = new ArrayList<>();
    }

    protected static MinibusRepositoryImpl getMinibusRepositoryImpl(){
        if(minibusRepositoryImpl == null){
            minibusRepositoryImpl = new MinibusRepositoryImpl();
        }
        return minibusRepositoryImpl;
    }

    @Override
    public Minibus create(Minibus minibus) {
        this.minibuses.add(minibus);
        return minibus;
    }

    @Override
    public Minibus update(Minibus minibus) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < minibuses.size();i++) {

            if (minibuses.get(i).getBusTypeCode() == minibus.getBusTypeCode()) {
                exists = true;
                index = i;
                minibuses.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent minibus.");
        }

        minibuses.add(index, minibus);
        return minibus;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < minibuses.size();i++) {

            if (minibuses.get(i).getBusTypeCode() == id) {
                minibuses.remove(i);
            }
        }

    }

    @Override
    public Minibus read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < minibuses.size();i++) {

            if (minibuses.get(i).getBusTypeCode() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return minibuses.get(index);
    }

    @Override
    public ArrayList<Minibus> getAll() {
        return minibuses;
    }
    @Override
    public void removeAll() {
        minibuses.removeAll(minibuses);
    }
}
