package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.MidibusRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface.MidibusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MidibusServiceImpl")
public class MidibusServiceImpl implements MidibusServiceInterface {

    @Autowired
    @Qualifier("MidibusRepository")
    private MidibusRepositoryImpl midibusRepositoryImpl;

    @Override
    public Midibus create(Midibus midibus) {
        return midibusRepositoryImpl.create(midibus);
    }

    @Override
    public Midibus update(Midibus midibus) {
        return midibusRepositoryImpl.update(midibus);
    }

    @Override
    public void delete(String busCode) {
        midibusRepositoryImpl.delete(busCode);
    }

    @Override
    public Midibus read(String busCode) {
        return midibusRepositoryImpl.read(busCode);
    }

    @Override
    public ArrayList<Midibus> getAll() {
        return midibusRepositoryImpl.getAll();
    }
}
