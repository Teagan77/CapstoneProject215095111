package org.randall.teagan.Domain.Trip;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Domain.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public class Trip {

    private String tripNo;
    private Date tripDate;
    private ArrayList<Customer> passengers;
    private Driver tripDriver;
    private Vehicle tripVehicle;
    private Route tripRoute;

    public Trip(){}

    public Trip(TripBuilder tripBuilder){
        this.tripNo = tripBuilder.tripNo;
        this.tripDate = tripBuilder.tripDate;
        this.passengers = tripBuilder.passengers;
        this.tripDriver = tripBuilder.tripDriver;
        this.tripRoute = tripBuilder.tripRoute;
        this.tripVehicle = tripBuilder.tripVehicle;
    }

    public String getTripNo() {
        return tripNo;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public ArrayList<Customer> getPassengers() {
        return passengers;
    }

    public Driver getTripDriver() {
        return tripDriver;
    }

    public Vehicle getTripVehicle() {
        return tripVehicle;
    }

    public Route getTripRoute() {
        return tripRoute;
    }

    public static class TripBuilder{

        private String tripNo;
        private Date tripDate;
        private ArrayList<Customer> passengers;
        private Driver tripDriver;
        private Vehicle tripVehicle;
        private Route tripRoute;

        public TripBuilder tripNo(String tripNo){
            this.tripNo = tripNo;
            return this;
        }

        public TripBuilder tripDate(Date tripDate){
            this.tripDate = tripDate;
            return this;
        }

        public TripBuilder tripPassengers(ArrayList<Customer> passengers){
            this.passengers = passengers;
            return this;
        }

        public TripBuilder tripDriver(Driver tripDriver){
            this.tripDriver = tripDriver;
            return this;
        }

        public TripBuilder tripVehicle(Vehicle tripVehcile){
            this.tripVehicle = tripVehcile;
            return this;
        }

        public TripBuilder tripRoute(Route tripRoute){
            this.tripRoute = tripRoute;
            return this;
        }

        public Trip build() {
            return new Trip(this);
        }

        public TripBuilder copy(Trip trip) {
            this.passengers = trip.passengers;
            this.tripDate = trip.tripDate;
            this.tripDriver = trip.tripDriver;
            this.tripNo = trip.tripNo;
            this.tripRoute = trip.tripRoute;
            this.tripVehicle = trip.tripVehicle;

            return this;
        }
    }
    @Override
    public String toString() {
        return "Trip{" +
                "tripNo ='" + getTripNo() + '\'' +
                ", tripDate ='" + getTripDate() + '\'' +
                ", passengers ='" + getPassengers() + '\'' +
                ", tripDriver ='" + getTripDriver() + '\'' +
                ", tripVehicle ='" + getTripVehicle() + '\'' +
                ", tripRoute ='" +getTripRoute() + '\'' +
                '}';
    }
}
