package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface.MiniBusRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("MinibusRepository")
public class MinibusRepositoryImpl implements MiniBusRepository {

    private ArrayList<Minibus> minibuses;

    private static MinibusRepositoryImpl minibusRepositoryImpl = null;

    private MinibusRepositoryImpl(){
        this.minibuses = new ArrayList<>();
    }

    public static MinibusRepositoryImpl getMinibusRepositoryImpl(){
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

        Minibus toDelete = findMinibus(minibus.getBusTypeCode());
        if(toDelete != null) {
            this.minibuses.remove(toDelete);
            return create(minibus);
        }
        return null;
    }

    private Minibus findMinibus(String busTypeCode) {
        return this.minibuses.stream()
                .filter(minibus -> minibus.getBusTypeCode().trim().equals(busTypeCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < minibuses.size();i++) {

            if (minibuses.get(i).getBusTypeCode().equals(id)) {
                minibuses.remove(i);
            }
        }

    }

    @Override
    public Minibus read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < minibuses.size();i++) {

            if (minibuses.get(i).getBusTypeCode().equals(id)) {
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
