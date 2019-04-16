package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.MemberType;

public class MemTypeBuilder {

    public static MemberType getMemberType(String memCode, String memTypeName) {
        return new MemberType.MemberTypeBuilder()
                .memType(memTypeName)
                .memCode(memCode)
                .build();
    }

}
