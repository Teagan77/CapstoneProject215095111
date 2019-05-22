package org.randall.teagan.Domain.Employee;

public class IssueStaff {

    private String jobTitleIssueStaff = "IssueStaff", positionCodeIssueStaff = "ISS003", issuerNo;

    public IssueStaff(){}

    private IssueStaff(IssueStaffBuilder issueStaffBuilder){
        this.jobTitleIssueStaff = issueStaffBuilder.jobTitleIssueStaff;
        this.positionCodeIssueStaff = issueStaffBuilder.positionCodeIssueStaff;
        this.issuerNo = issueStaffBuilder.issueNo;
    }

    public String getJobTitleIssueStaff(){
        return jobTitleIssueStaff;
    }

    public String getPositionCodeIssueStaff(){
        return positionCodeIssueStaff;
    }

    public String getIssuerNo() {
        return issuerNo;
    }

    public static class IssueStaffBuilder{

        private String jobTitleIssueStaff, positionCodeIssueStaff, issueNo;

        public IssueStaffBuilder jobTitleIssueStaff(String jobTitleIssueStaff) {
            this.jobTitleIssueStaff = jobTitleIssueStaff;
            return this;
        }

        public IssueStaffBuilder positionCodeIssueStaff(String positionCodeIssueStaff) {
            this.positionCodeIssueStaff = positionCodeIssueStaff;
            return this;
        }

        public IssueStaffBuilder issueNo(String issueNo){
            this.issueNo = issueNo;
            return this;
        }

        public IssueStaff build() {
            return new IssueStaff(this);
        }

        public IssueStaff.IssueStaffBuilder copy(IssueStaff saved) {
            this.jobTitleIssueStaff = saved.jobTitleIssueStaff;
            this.positionCodeIssueStaff = saved.positionCodeIssueStaff;
            this.issueNo = saved.issuerNo;

            return this;
        }
    }

    @Override
    public String toString() {
        return "IssueStaff{" +
                " positionCode ='" + getPositionCodeIssueStaff() + '\'' +
                " jobTitle ='" + getJobTitleIssueStaff() + '\'' +
                " issuer Number ='" + getIssuerNo() + '\'' +
                '}';
    }
}
