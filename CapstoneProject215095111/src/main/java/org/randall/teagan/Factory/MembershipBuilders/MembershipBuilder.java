package org.randall.teagan.Factory.MembershipBuilders;

import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;

public class MembershipBuilder {

    public static Membership getMembership(MemberType memType, String membershipID) {
        return new Membership.MembershipBuilder()
                .memType(memType)
                .membershipID(membershipID)
                .build();
    }
}
