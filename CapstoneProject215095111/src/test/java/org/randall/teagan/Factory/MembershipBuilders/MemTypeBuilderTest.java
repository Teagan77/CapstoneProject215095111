package org.randall.teagan.Factory.MembershipBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.MemberType;

import static org.junit.Assert.*;

public class MemTypeBuilderTest {

    @Test
    public void getMemberType() {

        String memCode = "ST002";
        String memTypeName = "FullMember" ;
        MemberType memberType = MemTypeBuilder.getMemberType(memCode,memTypeName);

        System.out.println(memberType);
        Assert.assertNotNull(memberType.getMemCode());
    }
}