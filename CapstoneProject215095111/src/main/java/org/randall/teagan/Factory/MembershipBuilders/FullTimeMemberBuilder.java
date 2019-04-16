package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.FullTimeMember;

public class FullTimeMemberBuilder {

    public static FullTimeMember getFullTimeMember(String memCode, String memTypeName) {
        return new FullTimeMember.FullTimeMemberBuilder()
                .memType(memTypeName)
                .memCode(memCode)
                .build();
    }
}
