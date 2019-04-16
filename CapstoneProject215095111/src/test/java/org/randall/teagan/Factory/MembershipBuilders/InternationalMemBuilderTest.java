package org.randall.teagan.Factory.MembershipBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.InternationalMember;

import static org.junit.Assert.*;

public class InternationalMemBuilderTest {

    @Test
    public void getInternationalMember() {
        String memName = "FullMember";
        String memCode = "FT001";
        String nationality = "German";

        InternationalMember internationalMem = InternationalMemBuilder.getInternationalMember(memCode,memName,nationality);

        System.out.println(internationalMem);
        Assert.assertNotNull(internationalMem.getMemCode());
    }
}