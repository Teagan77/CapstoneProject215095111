package org.randall.teagan.Domain.Customer;

public class Customer {

    private String customerID, custPhone, custName, custLastName;
    private int custAge;

    private Customer() {
    }

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.custName = builder.custName;
        this.custLastName = builder.custLastName;
        this.custAge = builder.custAge;
        this.custPhone = builder.custPhone;
    }

    public String getcustomerID() {
        return customerID;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public int getCustAge() {
        return custAge;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public static class Builder {

        private String customerID, custPhone, custName, custLastName;
        private int custAge;

        public Builder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder custName(String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custLastName(String custLastName) {
            this.custLastName = custLastName;
            return this;
        }

        public Builder age(int age) {
            this.custAge = age;
            return this;
        }

        public Builder custPhone(String custPhone) {
            this.custPhone = custPhone;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerID = customer.customerID;
            this.custName = customer.custName;
            this.custLastName = customer.custLastName;
            this.custAge = customer.custAge;
            this.custPhone = customer.custPhone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "ID = " + customerID + "\t" +
                "Name = " + custName + "\t" +
                "Surname = " + custLastName + "\t" +
                "Age = " + custAge + "\t" +
                "Phone = " + custPhone + "\t";
    }
}
