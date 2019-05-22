package org.randall.teagan.Domain.Trip;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Factory.TripBuilders.PassengerBuilder;

public class Passenger {

    private Customer passenger;

    public Passenger() {}

    public Passenger(PassengerBuilder passengerBuilder){
        this.passenger = passengerBuilder.passenger;
    }

    public Customer getPassenger() {
        return passenger;
    }

    public static class PassengerBuilder{

        private Customer passenger;

        public PassengerBuilder getPassenger(Customer passenger){
            this.passenger = passenger;
            return this;
        }

        public String getPassengerSurname() {
            return passenger.getCustLastName();
        }

        public Passenger build() {
            return new Passenger(this);
        }

        public Passenger.PassengerBuilder copy(Passenger passenger) {
            this.passenger = passenger.passenger;
            return this;
        }
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "passenger ='" + getPassenger() + '\'' +
                '}';
    }
}
