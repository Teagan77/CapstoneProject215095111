package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Factory.MembershipBuilders.InternationalMemBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InternationalMemRepositoryImplTest {

    private InternationalMemRepositoryImpl internationalMemRepositoryImpl;
    private InternationalMemBuilder internationalMemBuilder = new InternationalMemBuilder();

    String memName = "FullMember";
    String memCode = "INT001";
    String nationality = "German";
    String internationalMemID = "56466";

    String updatedNationality = "Australian";

    String memName2 = "FullMember";
    String memCode2 = "INT001";
    String nationality2 = "Korean";
    String internationalMemID2 = "16869";

    InternationalMember firstInternationalMem = InternationalMemBuilder.getInternationalMember(memCode,memName,nationality,internationalMemID);
    InternationalMember updatedInternationalMem = InternationalMemBuilder.getInternationalMember(memCode,memName,updatedNationality,internationalMemID);
    InternationalMember secondInternationalMem = InternationalMemBuilder.getInternationalMember(memCode2,memName2,nationality2,internationalMemID2);


    @Before
    public void setUp() throws Exception {
        this.internationalMemRepositoryImpl = InternationalMemRepositoryImpl.getInternationalMemRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstInternationalMem.hashCode(), this.internationalMemRepositoryImpl.create(firstInternationalMem).hashCode());
        this.internationalMemRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.internationalMemRepositoryImpl.create(firstInternationalMem);
        this.internationalMemRepositoryImpl.update(updatedInternationalMem);
        Assert.assertEquals("Australian", this.internationalMemRepositoryImpl.read(updatedInternationalMem.getInternationalMemID()).getNationality());
        this.internationalMemRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.internationalMemRepositoryImpl.create(firstInternationalMem);
        this.internationalMemRepositoryImpl.create(secondInternationalMem);
        this.internationalMemRepositoryImpl.delete(firstInternationalMem.getInternationalMemID());

        Assert.assertEquals(null, this.internationalMemRepositoryImpl.read(firstInternationalMem.getInternationalMemID()));
        this.internationalMemRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.internationalMemRepositoryImpl.create(firstInternationalMem);
        assertEquals(true, this.internationalMemRepositoryImpl.read(firstInternationalMem.getInternationalMemID()) instanceof InternationalMember);
        System.out.println(this.internationalMemRepositoryImpl.read(firstInternationalMem.getInternationalMemID()));
        this.internationalMemRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.internationalMemRepositoryImpl.create(firstInternationalMem);
        ArrayList<InternationalMember> internationalMembers = this.internationalMemRepositoryImpl.getAll();
        assertEquals(1, internationalMembers.size());
        this.internationalMemRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.internationalMemRepositoryImpl.create(firstInternationalMem);
        ArrayList<InternationalMember> internationalMembers = this.internationalMemRepositoryImpl.getAll();
        this.internationalMemRepositoryImpl.removeAll();
        Assert.assertEquals( 0,internationalMembers.size());
    }
}