package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Repositories.RepositoryInterfaces.CityLinerRepository;

import java.util.ArrayList;

public class CityLinerRepositoryImpl implements CityLinerRepository {

    private ArrayList<Cityliner> cityliners;

    private static CityLinerRepositoryImpl cityLinerRepositoryImpl = null;

    private CityLinerRepositoryImpl(){
        this.cityliners = new ArrayList<>();
    }

    protected static CityLinerRepositoryImpl getCityLinerRepositoryImpl(){
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
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < cityliners.size();i++) {

            if (cityliners.get(i).getBusTypeCode() == cityliner.getBusTypeCode()) {
                exists = true;
                index = i;
                cityliners.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent cityliner.");
        }

        cityliners.add(index, cityliner);
        return cityliner;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < cityliners.size();i++) {

            if (cityliners.get(i).getBusTypeCode() == id) {
                cityliners.remove(i);
            }
        }

    }

    @Override
    public Cityliner read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < cityliners.size();i++) {

            if (cityliners.get(i).getBusTypeCode() == id) {
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
