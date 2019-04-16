package org.randall.teagan.Domain.Employee;

public class IssueStaff {

    private String jobTitle = "IssueStaff", positionCode = "ISS003", issuerNo;

    public IssueStaff(){}

    private IssueStaff(IssueStaffBuilder issueStaffBuilder){
        this.jobTitle = issueStaffBuilder.jobTitle;
        this.positionCode = issueStaffBuilder.positionCode;
        this.issuerNo = issueStaffBuilder.issueNo;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public String getPositionCode(){
        return positionCode;
    }

    public String getIssuerNo() {
        return issuerNo;
    }

    public static class IssueStaffBuilder{

        private String jobTitle, positionCode, issueNo;

        public IssueStaffBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public IssueStaffBuilder positionCode(String positionCode) {
            this.positionCode = positionCode;
            return this;
        }

        public IssueStaffBuilder issueNo(String issueNo){
            this.issueNo = issueNo;
            return this;
        }

        public IssueStaff build() {
            return new IssueStaff(this);
        }

    }

    @Override
    public String toString() {
        return "IssueStaff{" +
                " positionCode ='" + getPositionCode() + '\'' +
                " jobTitle ='" + getJobTitle() + '\'' +
                " issuer Number ='" + getIssuerNo() + '\'' +
                '}';
    }
}
