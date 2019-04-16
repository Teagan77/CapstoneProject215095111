package org.randall.teagan.Factory.MembershipBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.StudentMember;

import static org.junit.Assert.*;

public class StudentMemberBuilderTest {

    @Test
    public void getMemberType() {
        String memName = "Student Member";
        String memCode = "ST004";
        String studNo = "615165165";

        StudentMember studMem = StudentMemberBuilder.getStudMember(memCode,memName,studNo);

        System.out.println(studMem);
        Assert.assertNotNull(studMem.getMemCode());
    }
}