package org.randall.teagan.Domain.Employee;

public class EmpContact {

    private String contactNo;

    private EmpContact(){}

    private EmpContact(EmpContactBuilder empContactBuilder ){
        this.contactNo = empContactBuilder.contactNo;
    }

    public String getContactNo(){
        return contactNo;
    }

    public static class EmpContactBuilder{

        private String contactNo;

        public EmpContactBuilder contactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public EmpContact build() {
            return new EmpContact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                " contactNo ='" + getContactNo() + '\'' +
                '}';
    }
}
