package org.randall.teagan.Domain.Customer;

import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Services.Person;

public class Customer implements Person {

    private String custId, custPhone, custName, custLastName, custGender;
    private int custAge;
    private double custCredit;
    private Membership membership;

    private Customer(){}

    private Customer(Builder builder) {
        this.custId = builder.custId;
        this.custPhone = builder.custPhone;
        this.custAge = builder.custAge;
        this.custName = builder.custName;
        this.custLastName = builder.custLastName;
        this.custCredit = builder.custCredit;
        this.custGender = builder.custGender;
        this.membership = builder.membership;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustPhone() {
        return custPhone;
    }

    @Override
    public String getName() {
        return custName;
    }

    @Override
    public String getSurname() {
        return custLastName;
    }

    public int getAge() {
        return custAge;
    }

    @Override
    public String getGender() {
        return custGender;
    }

    public double getCredit() {
        return custCredit;
    }

    public Membership getMembership() {
        return membership;
    }

    public static class Builder {

        private String custId, custPhone, custName, custLastName, custGender;
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

        public Builder custLastName(String custLastName) {
            this.custLastName = custLastName;
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

        public Customer build() {
            return new Customer(this);
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID ='" + getCustId() + '\'' +
                ", custName ='" + getName() + '\'' +
                ", custLastName ='" + getSurname() + '\'' +
                ", age =" + getAge() +
                ", custPhone ='" + getCustPhone() + '\'' +
                ", custCredit ='" + getCredit() + '\'' +
                ", membership ='" + getMembership() + '\'' +
                '}';
    }
}
