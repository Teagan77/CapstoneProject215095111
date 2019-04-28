package org.randall.teagan.Factory.MembershipBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;

import static org.junit.Assert.*;

public class MembershipBuilderTest {

    @Test
    public void getMembership() {

        String memId = "15156515";
        String memCode = "ST002";
        String memTypeName = "FullMember" ;
        MemberType memberType = MemTypeBuilder.getMemberType(memCode,memTypeName);

        Membership membership = MembershipBuilder.getMembership(memberType, memId);

        System.out.println(membership);
        Assert.assertNotNull(membership.getMembershipID());
    }
}