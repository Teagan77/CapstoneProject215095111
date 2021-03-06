package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Factory.MembershipBuilders.FullTimeMemberBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.FullMemRepositoryImpl;

import java.util.ArrayList;

public class FullMemRepositoryImplTest {

    private FullMemRepositoryImpl fullMemRepositoryImpl;
    private FullTimeMemberBuilder fullTimeMemberBuilder = new FullTimeMemberBuilder();

    String memName = "FullMember";
    String memCode = "FT001";
    String memID = "54864";

    String updateMemName = "Full-Time-Member";

    String memName2 = "FullMember";
    String memCode2 = "FT987";
    String memID2 = "d864d";


    FullTimeMember firstFullmem = FullTimeMemberBuilder.getFullTimeMember(memCode, memName, memID);
    FullTimeMember updatedFirstFullmem = FullTimeMemberBuilder.getFullTimeMember(memCode,updateMemName,memID);
    FullTimeMember secondFullmem = FullTimeMemberBuilder.getFullTimeMember(memCode2,memName2,memID2);

    @Before
    public void setUp() throws Exception {
        this.fullMemRepositoryImpl = FullMemRepositoryImpl.getFullMemRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstFullmem.hashCode(), this.fullMemRepositoryImpl.create(firstFullmem).hashCode());
        this.fullMemRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.fullMemRepositoryImpl.create(firstFullmem);
        this.fullMemRepositoryImpl.update(updatedFirstFullmem);
        Assert.assertEquals("Full-Time-Member", this.fullMemRepositoryImpl.read(updatedFirstFullmem.getFullTimeMemCode()).getMemTypeName());
        this.fullMemRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.fullMemRepositoryImpl.create(firstFullmem);
        this.fullMemRepositoryImpl.create(secondFullmem);
        this.fullMemRepositoryImpl.delete(firstFullmem.getMemCode());

        Assert.assertEquals(null, this.fullMemRepositoryImpl.read(firstFullmem.getMemCode()));
        this.fullMemRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.fullMemRepositoryImpl.create(firstFullmem);
        Assert.assertEquals(true, this.fullMemRepositoryImpl.read(firstFullmem.getFullTimeMemCode()) instanceof FullTimeMember);
        System.out.println(this.fullMemRepositoryImpl.read(firstFullmem.getMemCode()));
        this.fullMemRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.fullMemRepositoryImpl.create(firstFullmem);
        ArrayList<FullTimeMember> fullTimeMembers = this.fullMemRepositoryImpl.getAll();
        Assert.assertEquals(1, fullTimeMembers.size());
        this.fullMemRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.fullMemRepositoryImpl.create(firstFullmem);
        ArrayList<FullTimeMember> fullTimeMembers = this.fullMemRepositoryImpl.getAll();
        this.fullMemRepositoryImpl.removeAll();
        Assert.assertEquals( 0,fullTimeMembers.size());
    }
}