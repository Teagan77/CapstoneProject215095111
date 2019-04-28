package org.randall.teagan.Domain.Employee;

public class EmployeePosition{

    private String jobTitle, positionCode;

    public EmployeePosition(){}

    private EmployeePosition(EmployeePositionBuilder empPosBuilder){
        this.jobTitle = empPosBuilder.jobTitle;
        this.positionCode = empPosBuilder.positionCode;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public String getPositionCode(){
        return positionCode;
    }

    public static class EmployeePositionBuilder{

        private String jobTitle, positionCode;

        public EmployeePositionBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public EmployeePositionBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public EmployeePosition build() {
            return new EmployeePosition(this);
        }

    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                " positionCode ='" + getPositionCode() + '\'' +
                " jobTitle ='" + getJobTitle() + '\'' +
                '}';
    }
}