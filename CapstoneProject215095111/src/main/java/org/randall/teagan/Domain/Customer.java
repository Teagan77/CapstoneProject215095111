package org.randall.teagan.Domain;

public class Customer {

    private String custId, custPhone, custName, custLastName;
    private int age;
    private double custCredit;

    private Customer(){}

    private Customer(Builder builder) {
        this.custId = builder.custId;
        this.custPhone = builder.custPhone;
        this.age = builder.age;
        this.custName = builder.custName;
        this.custLastName = builder.custLastName;
        this.custCredit = builder.custCredit;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public int getAge() {
        return age;
    }

    public double getCredit() {
        return custCredit;
    }

    public static class Builder {

        private String custId, custPhone, custName, custLastName;
        private int age;
        private double custCredit;

        public Builder custId(String custId) {
            this.custId = custId;
            return this;
        }

        public Builder custName( String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custLastName( String custLastName) {
            this.custLastName = custLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
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

        public Customer build() {
            return new Customer(this);
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID ='" + custId + '\'' +
                ", custName ='" + custName + '\'' +
                ", custLastName ='" + custLastName + '\'' +
                ", age =" + age +
                ", custPhone ='" + custPhone + '\'' +
                ", custCredit ='" + custCredit + '\'' +
                '}';
    }
}
