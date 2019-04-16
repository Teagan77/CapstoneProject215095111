package org.randall.teagan.Domain.Employee;

import org.randall.teagan.Domain.Services.Person;

public class Employee implements Person {

    private int empAge;
    private String empName, empSurname, empId, empGender;
    private EmployeePosition empPos;
    private EmployeePayslip empPay;
    private EmpAddress empAddress;
    private EmpContact empContact;

    private Employee(){}

    private Employee(EmpBuilder empBuilder){
        this.empId = empBuilder.empId;
        this.empAge = empBuilder.empAge;
        this.empName = empBuilder.empName;
        this.empSurname = empBuilder.empSurname;
        this.empGender = empBuilder.empGender;
        this.empPos = empBuilder.empPos;
        this.empPay = empBuilder.empPay;
        this.empAddress = empBuilder.empAddress;
        this.empContact = empBuilder.empContact;
    }

    public String getId() {
        return empId;
    }

    public EmployeePosition getEmpPos(){
        return this.empPos;
    }

    public EmployeePayslip getEmpPay(){
        return this.empPay;
    }

    public EmpAddress getEmpAddress(){
        return this.empAddress;
    }

    public EmpContact getEmpContact(){
        return this.empContact;
    }

    @Override
    public String getName() {
        return empName;
    }
    @Override
    public String getSurname() {
        return empSurname;
    }

    @Override
    public int getAge() {
        return empAge;
    }

    @Override
    public String getGender() {
        return empGender;
    }

    public static class EmpBuilder{

        private int empAge;
        private String empName, empSurname, empId, empGender;
        private EmployeePosition empPos;
        private EmployeePayslip empPay;
        private EmpAddress empAddress;
        private EmpContact empContact;

        public EmpBuilder empId(String empId) {
            this.empId = empId;
            return this;
        }

        public EmpBuilder empName(String empName) {
            this.empName = empName;
            return this;
        }

        public EmpBuilder empSurname(String empSurname){
            this.empSurname = empSurname;
            return this;
        }

        public EmpBuilder empAge(int empAge){
            this.empAge = empAge;
            return this;
        }

        public EmpBuilder empGender(String empGender){
            this.empGender = empGender;
            return this;
        }

        public EmpBuilder empPos(EmployeePosition empPos){
            this.empPos = empPos;
            return this;
        }

        public EmpBuilder empPay(EmployeePayslip empPay){
            this.empPay = empPay;
            return this;
        }

        public EmpBuilder empAddress(EmpAddress empAddress){
            this.empAddress = empAddress;
            return this;
        }

        public EmpBuilder empContact(EmpContact empContact){
            this.empContact = empContact;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID ='" + empId + '\'' +
                ", empName ='" + empName + '\'' +
                ", empSurname ='" + empSurname + '\'' +
                ", empAge =" + empAge +
                ", empGender ='" + empGender + '\'' +
                ", empContact ='" + getEmpContact().toString() + '\'' +
                ", empPosition ='" + getEmpPos().toString() + '\'' +
                ", empPayslip ='" + getEmpPay().toString() + '\'' +
                ", empAddress ='" + getEmpAddress().toString() + '\'' +
                '}';
    }
}
