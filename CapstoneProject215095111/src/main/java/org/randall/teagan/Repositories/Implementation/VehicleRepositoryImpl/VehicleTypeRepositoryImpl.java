package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl;

import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface.VehicleTypeRepository;
import java.util.ArrayList;

public class VehicleTypeRepositoryImpl implements VehicleTypeRepository {

    private ArrayList<BusType> busTypes;

    private static VehicleTypeRepositoryImpl vehicleTypeRepositoryImpl = null;

    private VehicleTypeRepositoryImpl(){
        this.busTypes = new ArrayList<>();
    }

    public static VehicleTypeRepositoryImpl getVehicleTypeRepositoryImpl(){
        if(vehicleTypeRepositoryImpl == null){
            vehicleTypeRepositoryImpl = new VehicleTypeRepositoryImpl();
        }
        return vehicleTypeRepositoryImpl;
    }

    @Override
    public BusType create(BusType busType) {
        this.busTypes.add(busType);
        return busType;
    }

    @Override
    public BusType update(BusType busType) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < busTypes.size();i++) {

            if (busTypes.get(i).getBusTypeCode() == busType.getBusTypeCode()) {
                exists = true;
                index = i;
                busTypes.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent busType.");
        }

        busTypes.add(index, busType);
        return busType;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < busTypes.size();i++) {

            if (busTypes.get(i).getBusTypeCode() == id) {
                busTypes.remove(i);
            }
        }

    }

    @Override
    public BusType read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < busTypes.size();i++) {

            if (busTypes.get(i).getBusTypeCode() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return busTypes.get(index);
    }

    @Override
    public ArrayList<BusType> getAll() {
        return busTypes;
    }

    @Override
    public void removeAll() {
        busTypes.removeAll(busTypes);
    }
}
