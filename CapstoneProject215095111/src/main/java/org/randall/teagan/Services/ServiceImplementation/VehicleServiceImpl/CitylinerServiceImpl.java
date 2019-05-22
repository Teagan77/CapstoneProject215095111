package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.CityLinerRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface.CitylinerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("CitylinerServiceImpl")
public class CitylinerServiceImpl implements CitylinerServiceInterface {

    @Autowired
    @Qualifier("CitylinerRepository")
    private CityLinerRepositoryImpl cityLinerRepositoryImpl;

    @Override
    public Cityliner create(Cityliner cityliner) {
        return cityLinerRepositoryImpl.create(cityliner);
    }

    @Override
    public Cityliner update(Cityliner cityliner) {
        return cityLinerRepositoryImpl.update(cityliner);
    }

    @Override
    public void delete(String busCode) {
        cityLinerRepositoryImpl.delete(busCode);
    }

    @Override
    public Cityliner read(String busCode) {
        return cityLinerRepositoryImpl.read(busCode);
    }

    @Override
    public ArrayList<Cityliner> getAll() {
        return cityLinerRepositoryImpl.getAll();
    }
}
