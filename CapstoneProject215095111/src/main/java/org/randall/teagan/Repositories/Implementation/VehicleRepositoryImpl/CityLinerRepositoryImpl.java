package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface.CityLinerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("CitylinerRepository")
public class CityLinerRepositoryImpl implements CityLinerRepository {

    private ArrayList<Cityliner> cityliners;

    private static CityLinerRepositoryImpl cityLinerRepositoryImpl = null;

    private CityLinerRepositoryImpl(){
        this.cityliners = new ArrayList<>();
    }

    public static CityLinerRepositoryImpl getCityLinerRepositoryImpl(){
        if(cityLinerRepositoryImpl == null){
            cityLinerRepositoryImpl = new CityLinerRepositoryImpl();
        }
        return cityLinerRepositoryImpl;
    }

    @Override
    public Cityliner create(Cityliner cityliner) {
        this.cityliners.add(cityliner);
        return cityliner;
    }

    @Override
    public Cityliner update(Cityliner cityliner) {

        Cityliner toDelete = findCourse(cityliner.getBusTypeCode());
        if(toDelete != null) {
            this.cityliners.remove(toDelete);
            return create(cityliner);
        }
        return null;
    }

    private Cityliner findCourse(String busTypeCode) {
        return this.cityliners.stream()
                .filter(cityliner -> cityliner.getBusTypeCode().trim().equals(busTypeCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < cityliners.size();i++) {

            if (cityliners.get(i).getBusTypeCode().equals(id)) {
                cityliners.remove(i);
            }
        }

    }

    @Override
    public Cityliner read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < cityliners.size();i++) {

            if (cityliners.get(i).getBusTypeCode().equals(id)) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return cityliners.get(index);
    }

    @Override
    public ArrayList<Cityliner> getAll() {
        return cityliners;
    }
    @Override
    public void removeAll() {
        cityliners.removeAll(cityliners);
    }
}
