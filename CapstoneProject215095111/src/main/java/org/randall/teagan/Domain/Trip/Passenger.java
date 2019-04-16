package org.randall.teagan.Domain.Trip;

import org.randall.teagan.Domain.Customer.Customer;

public class Passenger {

    private Customer passenger;
    private Trip currentTrip;

    public Passenger() {}

    public Passenger(PassengerBuilder passengerBuilder){
        this.passenger = passengerBuilder.passenger;
        this.currentTrip = passengerBuilder.currentTrip;
    }

    public Customer getPassenger() {
        return passenger;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public static class PassengerBuilder{

        private Customer passenger;
        private Trip currentTrip;

        public PassengerBuilder getPassenger(Customer passenger){
            this.passenger = passenger;
            return this;
        }

        public PassengerBuilder getCurrentTrip(Trip currentTrip){
            this.currentTrip = currentTrip;
            return this;
        }

        public Passenger build() {
            return new Passenger(this);
        }
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "passenger ='" + getPassenger() + '\'' +
                ", currentTrip ='" + getCurrentTrip() + '\'' +
                '}';
    }
}
