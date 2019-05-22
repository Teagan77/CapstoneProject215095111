package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.FullTimeMember;

public class FullTimeMemberBuilder {

    public static FullTimeMember getFullTimeMember(String memCode, String memTypeName, String fullTimeMemCode) {
        return new FullTimeMember.FullTimeMemberBuilder()
                .memType(memTypeName)
                .memCode(memCode)
                .fullTimeMemberBuilder(fullTimeMemCode)
                .build();
    }
}
