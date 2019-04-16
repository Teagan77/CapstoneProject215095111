package org.randall.teagan.Domain.Vehicle;

public class Vehicle {

    private String registration;
    private BusType busType;
    private int capacity;

    public Vehicle(){}

    public Vehicle(VehicleBuilder vehicleBuilder){
        this.busType = vehicleBuilder.busType;
        this.registration = vehicleBuilder.registration;
        this.capacity = vehicleBuilder.capacity;
    }

    public String getRegistration() {
        return registration;
    }

    public BusType getBustType() {
        return busType;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class VehicleBuilder{

        private String registration;
        private BusType busType;
        private int capacity;

        public VehicleBuilder bustType(BusType bustType){
            this.busType = bustType;
            return this;
        }

        public VehicleBuilder registration(String registration){
            this.registration = registration;
            return this;
        }

        public VehicleBuilder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "busType ='" + getBustType() + '\'' +
                ", registration ='" + getRegistration() + '\'' +
                "capacity ='" + getCapacity() + '\'' +
                '}';
    }
}
