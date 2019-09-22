package org.randall.teagan.Domain.Request;

public class NewCustomer {

    private String customerID, custPhone, custName, custLastName;
    private int custAge;

    public NewCustomer(){}

    public NewCustomer(String customerID, String custPhone, String custName, String custLastName, int custAge) {
        this.customerID = customerID;
        this.custPhone = custPhone;
        this.custName = custName;
        this.custLastName = custLastName;
        this.custAge = custAge;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public int getCustAge() {
        return custAge;
    }

    public void setCustAge(int custAge) {
        this.custAge = custAge;
    }

    @Override
    public String toString() {
        return "NewCustomer{" +
                "customerID='" + customerID + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custName='" + custName + '\'' +
                ", custLastName='" + custLastName + '\'' +
                ", custAge=" + custAge +
                '}';
    }
}
