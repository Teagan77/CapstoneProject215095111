package org.randall.teagan.Domain.Employee;

import org.randall.teagan.Domain.Customer.Customer;

public class Mechanic extends EmployeePosition {

    private String jobTitle = "Mechanic" , positionCode = "MEC002", qualCode = "NDIP MECHENG", mechanicID = "5449849";

    private Mechanic(){}

    private Mechanic(MechanicBuilder mechanicBuilder){
        this.jobTitle = mechanicBuilder.jobTitle;
        this.positionCode = mechanicBuilder.positionCode;
        this.qualCode = mechanicBuilder.qualCode;
        this.mechanicID = mechanicBuilder.mechanicID;
    }

    public String getQualCode(){
        return qualCode;
    }

    @Override
    public String getJobTitle(){
        return jobTitle;
    }

    @Override
    public String getPositionCode(){
        return positionCode;
    }

    public String getMechanicID() {
        return mechanicID;
    }

    public static class MechanicBuilder{

        private String jobTitle, positionCode, qualCode, mechanicID;

        public MechanicBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public MechanicBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public MechanicBuilder qualCode(String qualCode){
            this.qualCode = qualCode;
            return this;
        }

        public MechanicBuilder mechanicID(String mechanicID){
            this.mechanicID = mechanicID;
            return this;
        }

        public Mechanic build() {
            return new Mechanic(this);
        }

        public Mechanic.MechanicBuilder copy(Mechanic mechanic) {
            this.mechanicID = mechanic.mechanicID;
            this.jobTitle = mechanic.jobTitle;
            this.positionCode = mechanic.positionCode;
            this.qualCode = mechanic.qualCode;

            return this;
        }
    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                " positionCode ='" + getPositionCode() + '\'' +
                " jobTitle ='" + getJobTitle() + '\'' +
                " qualCode ='" + getQualCode() + '\'' +
                " mechanicID ='" + getMechanicID() + '\'' +
                '}';
    }
}
