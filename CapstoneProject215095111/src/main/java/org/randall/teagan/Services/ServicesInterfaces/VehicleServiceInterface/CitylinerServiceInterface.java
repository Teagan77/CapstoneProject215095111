package org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface CitylinerServiceInterface extends GenericService<Cityliner, String> {
    ArrayList<Cityliner>getAll();
}
