package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.InternationalMember;

public class InternationalMemBuilder {

    public static InternationalMember getInternationalMember(String memCode, String memTypeName, String nationality, String internationalMemID) {
        return new InternationalMember.InternationalMemBuilder()
                .memType(memTypeName)
                .memCode(memCode)
                .nationality(nationality)
                .internationalMemID(internationalMemID)
                .build();
    }
}
