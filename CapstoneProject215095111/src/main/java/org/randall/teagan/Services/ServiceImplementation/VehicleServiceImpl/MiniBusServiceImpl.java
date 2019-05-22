package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.MinibusRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface.MiniBusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("MiniBusServiceImpl")
public class MiniBusServiceImpl implements MiniBusServiceInterface {

    @Autowired
    @Qualifier("MinibusRepository")
    private MinibusRepositoryImpl minibusRepositoryImpl;

    @Override
    public Minibus create(Minibus minibus) {
        return minibusRepositoryImpl.create(minibus);
    }

    @Override
    public Minibus update(Minibus minibus) {
        return minibusRepositoryImpl.update(minibus);
    }

    @Override
    public void delete(String busCode) {
        minibusRepositoryImpl.delete(busCode);
    }

    @Override
    public Minibus read(String busCode) {
        return minibusRepositoryImpl.read(busCode);
    }

    @Override
    public ArrayList<Minibus> getAll() {
        return minibusRepositoryImpl.getAll();
    }
}
