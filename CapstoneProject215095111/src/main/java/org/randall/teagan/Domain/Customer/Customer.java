package org.randall.teagan.Domain.Customer;

import org.randall.teagan.Domain.Membership.Membership;

public class Customer{

    private String custId, custPhone, custName, custLName, custGender;
    private int custAge;
    private double custCredit;
    private Membership membership;

    private Customer(){}

    private Customer(Builder builder) {
        this.custId = builder.custId;
        this.custName = builder.custName;
        this.custLName = builder.custLName;
        this.custAge = builder.custAge;
        this.custPhone = builder.custPhone;
        this.custCredit = builder.custCredit;
        this.custGender = builder.custGender;
        this.membership = builder.membership;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustLastName() {return custLName;}

    public int getCustAge() {
        return custAge;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public double getCustCredit() {
        return custCredit;
    }

    public String getCustGender() {
        return custGender;
    }

    public Membership getMembership() {
        return membership;
    }

    public static class Builder {

        private String custId, custPhone, custName, custLName, custGender;
        private int custAge;
        private double custCredit;
        private Membership membership;

        public Builder custId(String custId) {
            this.custId = custId;
            return this;
        }

        public Builder custName(String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custLName(String custLastName){
            this.custLName = custLastName;
            return this;
        }

        public Builder age(int age) {
            this.custAge = age;
            return this;
        }

        public Builder custPhone(String custPhone){
            this.custPhone = custPhone;
            return this;
        }

        public Builder custCredit(double custCredit){
            this.custCredit = custCredit;
            return this;
        }

        public Builder custGender(String custGender){
            this.custGender = custGender;
            return this;
        }

        public Builder membership(Membership membership){
            this.membership = membership;
            return this;
        }

        public Builder copy(Customer customer){
            this.custId = customer.custId;
            this.custName = customer.custName;
            this.custLName = customer.custLName;
            this.custAge = customer.custAge;
            this.custPhone = customer.custPhone;
            this.custCredit = customer.custCredit;
            this.custGender = customer.custGender;
            this.membership = customer.membership;

            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "ID = " + custId + "\t" +
                "Name = " + custName + "\t" +
                "Surname = " + custLName + "\t" +
                "Age = " + custAge + "\t" +
                "Phone = " + custPhone + "\t" +
                "Credit = " + custCredit + "\t" +
                "Gender = " + custGender + "\t" +
                "Membership = " + membership;
    }
}
