package org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface MiniBusServiceInterface extends GenericService<Minibus, String> {
    ArrayList<Minibus> getAll();
}
