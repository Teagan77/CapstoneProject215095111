package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.IssueStaff;

public class IssueStaffBuilder {

    public static IssueStaff getIssueStaff(String jobTitle, String positionCode, String issuerNo) {
        return new IssueStaff.IssueStaffBuilder()
                .jobTitle(jobTitle)
                .positionCode(positionCode)
                .issueNo(issuerNo)
                .build();
    }
}
