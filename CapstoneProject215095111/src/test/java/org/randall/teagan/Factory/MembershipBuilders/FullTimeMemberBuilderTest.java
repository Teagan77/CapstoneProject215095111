package org.randall.teagan.Factory.MembershipBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.FullTimeMember;

import static org.junit.Assert.*;

public class FullTimeMemberBuilderTest {

    @Test
    public void getFullTimeMember() {

        String memName = "FullMember";
        String memCode = "FT001";
        String memID = "000987";

        FullTimeMember fullmem = FullTimeMemberBuilder.getFullTimeMember(memName,memCode,memID);

        System.out.println(fullmem);
        Assert.assertNotNull(fullmem.getMemCode());
    }
}