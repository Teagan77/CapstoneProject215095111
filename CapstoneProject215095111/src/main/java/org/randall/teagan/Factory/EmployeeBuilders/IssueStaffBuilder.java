package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.IssueStaff;

public class IssueStaffBuilder {

    public static IssueStaff getIssueStaff(String jobTitleIssueStaff, String positionCodeIssueStaff, String issuerNo) {
        return new IssueStaff.IssueStaffBuilder()
                .jobTitleIssueStaff(jobTitleIssueStaff)
                .positionCodeIssueStaff(positionCodeIssueStaff)
                .issueNo(issuerNo)
                .build();
    }
}
