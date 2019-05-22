package org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;
import java.util.ArrayList;

public interface MidibusServiceInterface extends GenericService<Midibus, String> {
    ArrayList<Midibus> getAll();
}
