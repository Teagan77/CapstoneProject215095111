package org.randall.teagan.Domain.Employee;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeePayslip {

    private double grossPay;
    private Date payDate;

    private EmployeePayslip(){}

    private EmployeePayslip(EmpPayslipBuilder empPayslipBuilder){
        this.grossPay = empPayslipBuilder.grossPay;
        this.payDate = empPayslipBuilder.payDate;

    }

    public double getGrossPay() {
        return grossPay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public static class EmpPayslipBuilder{

        private double grossPay;
        private Date payDate;

        public EmpPayslipBuilder grossPay(double grossPay) {
            this.grossPay = grossPay;
            return this;
        }

        public EmpPayslipBuilder payDate(Date payDate) {
            this.payDate = payDate;
            return this;
        }

        public EmployeePayslip build() {
            return new EmployeePayslip(this);
        }
    }

    @Override
    public String toString() {
        return "Payslip{" +
                " grossPay ='" + getGrossPay() + '\'' +
                " payDate ='" + getPayDate() + '\'' +
                '}';
    }
}
