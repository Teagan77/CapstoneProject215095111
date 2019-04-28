package org.randall.teagan.Domain.Employee;

public class Driver extends EmployeePosition {

    private String jobTitle = "Driver", positionCode = "DRV001", licenseCode = "Code C", driverID = "00000";

    private Driver(){}

    private Driver(DriverBuilder driverBuilder){
        this.jobTitle = driverBuilder.jobTitle;
        this.licenseCode = driverBuilder.licenseCode;
        this.positionCode = driverBuilder.positionCode;
        this.driverID = driverBuilder.driverID;
    }

    public String getLicenseCode(){
        return licenseCode;
    }

    @Override
    public String getJobTitle(){
        return jobTitle;
    }

    @Override
    public String getPositionCode(){
        return positionCode;
    }

    public String getDriverID() {
        return driverID;
    }

    public static class DriverBuilder{

        private String jobTitle, positionCode, licenseCode, driverID;

        public DriverBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public DriverBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public DriverBuilder licenseCode(String licenseCode){
            this.licenseCode = licenseCode;
            return this;
        }

        public DriverBuilder driverID(String driverID){
            this.driverID = driverID;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }

    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                " positionCode ='" + getPositionCode() + '\'' +
                " jobTitle ='" + getJobTitle() + '\'' +
                " licenseCode ='" + getLicenseCode() + '\'' +
                " driverCode ='" + getDriverID() + '\'' +
                '}';
    }
}

