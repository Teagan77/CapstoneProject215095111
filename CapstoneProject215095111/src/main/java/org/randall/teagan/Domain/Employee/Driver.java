package org.randall.teagan.Domain.Employee;

public class Driver{

    private String jobTitleDriver, positionCodeDriver, licenseCodeDriver, driverID;

    private Driver(){}

    private Driver(DriverBuilder driverBuilder){
        this.jobTitleDriver = driverBuilder.jobTitleDriver;
        this.licenseCodeDriver = driverBuilder.licenseCodeDriver;
        this.positionCodeDriver = driverBuilder.positionCodeDriver;
        this.driverID = driverBuilder.driverID;
    }

    public String getDriverLicenseCode(){
        return licenseCodeDriver;
    }

    public String getDriverJobTitle(){
        return jobTitleDriver;
    }

    public String getDriverPositionCode(){
        return positionCodeDriver;
    }

    public String getDriverID() {
        return driverID;
    }

    public static class DriverBuilder{

        private String jobTitleDriver, positionCodeDriver, licenseCodeDriver, driverID;

        public DriverBuilder jobTitleDriver(String jobTitleDriver) {
            this.jobTitleDriver = jobTitleDriver;
            return this;
        }

        public DriverBuilder positionCodeDriver(String positionCodeDriver) {
            this.positionCodeDriver = positionCodeDriver;
            return this;
        }

        public DriverBuilder licenseCode(String licenseCodeDriver){
            this.licenseCodeDriver = licenseCodeDriver;
            return this;
        }

        public DriverBuilder driverID(String driverID){
            this.driverID = driverID;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }

        public DriverBuilder copy(Driver driver){
            this.jobTitleDriver = driver.jobTitleDriver;
            this.licenseCodeDriver = driver.licenseCodeDriver;
            this.positionCodeDriver = driver.positionCodeDriver;
            this.driverID = driver.driverID;

            return this;
        }
    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                " positionCode ='" + getDriverPositionCode() + '\'' +
                " jobTitle ='" + getDriverJobTitle() + '\'' +
                " licenseCode ='" + getDriverLicenseCode() + '\'' +
                " driverCode ='" + getDriverID() + '\'' +
                '}';
    }
}

