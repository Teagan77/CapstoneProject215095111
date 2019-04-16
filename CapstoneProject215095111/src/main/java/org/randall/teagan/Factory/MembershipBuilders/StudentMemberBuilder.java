package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.StudentMember;

public class StudentMemberBuilder {

    public static StudentMember getStudMember(String memCode, String memTypeName, String studNo) {
        return new StudentMember.StudentMemBuilder()
                .memType(memTypeName)
                .memCode(memCode)
                .studNo(studNo)
                .build();
    }
}
