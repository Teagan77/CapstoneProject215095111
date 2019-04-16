package org.randall.teagan.Domain.Employee;

public class Manager extends EmployeePosition{

    private String jobTitle = "Manager" , positionCode = "MGR004", qualCode = "NDIP BUSMGM";

    private Manager(){}

    private Manager(ManagerBuilder managerBuilder){
        this.jobTitle = managerBuilder.jobTitle;
        this.positionCode = managerBuilder.positionCode;
        this.qualCode = managerBuilder.qualCode;
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

    public static class ManagerBuilder{

        private String jobTitle, positionCode, qualCode;

        public ManagerBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public ManagerBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public ManagerBuilder qualCode(String qualCode){
            this.qualCode = qualCode;
            return this;
        }

        public Manager build() {
            return new Manager(this);
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
