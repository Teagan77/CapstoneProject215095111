package org.randall.teagan.Domain.Employee;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeePayslip {

    private double grossPay;
    private Date payDate;
    private String payslipID;

    private EmployeePayslip(){}

    private EmployeePayslip(EmpPayslipBuilder empPayslipBuilder){
        this.grossPay = empPayslipBuilder.grossPay;
        this.payDate = empPayslipBuilder.payDate;
        this.payslipID = empPayslipBuilder.payslipID;

    }

    public double getGrossPay() {
        return grossPay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public String getPayslipID() {
        return payslipID;
    }

    public static class EmpPayslipBuilder{

        private double grossPay;
        private Date payDate;
        String payslipID;

        public EmpPayslipBuilder grossPay(double grossPay) {
            this.grossPay = grossPay;
            return this;
        }

        public EmpPayslipBuilder payDate(Date payDate) {
            this.payDate = payDate;
            return this;
        }

        public EmpPayslipBuilder payslipID(String payslipID) {
            this.payslipID = payslipID;
            return this;
        }

        public EmployeePayslip build() {
            return new EmployeePayslip(this);
        }

        public EmployeePayslip.EmpPayslipBuilder copy(EmployeePayslip employeePayslip) {
            this.grossPay = employeePayslip.grossPay;
            this.payslipID = employeePayslip.payslipID;
            this.payDate = employeePayslip.payDate;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Payslip{" +
                " grossPay ='" + getGrossPay() + '\'' +
                " payDate ='" + getPayDate() + '\'' +
                " payslipID ='" + getPayslipID() + '\'' +
                '}';
    }
}
