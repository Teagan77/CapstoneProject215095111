package org.randall.teagan.Domain.Employee;

public class Mechanic extends EmployeePosition {

    private String jobTitle = "Mechanic" , positionCode = "MEC002", qualCode = "NDIP MECHENG";

    private Mechanic(){}

    private Mechanic(MechanicBuilder mechanicBuilder){
        this.jobTitle = mechanicBuilder.jobTitle;
        this.positionCode = mechanicBuilder.positionCode;
        this.qualCode = mechanicBuilder.qualCode;
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

    public static class MechanicBuilder{

        private String jobTitle, positionCode, qualCode;

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

        public Mechanic build() {
            return new Mechanic(this);
        }

    }

    @Override
    public String toString() {
        return "EmployeePosition{" +
                " positionCode ='" + getPositionCode() + '\'' +
                " jobTitle ='" + getJobTitle() + '\'' +
                " qualCode ='" + getQualCode() + '\'' +
                '}';
    }
}
