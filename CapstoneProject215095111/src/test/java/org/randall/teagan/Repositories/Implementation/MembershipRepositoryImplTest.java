package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;

import java.util.ArrayList;

public class MembershipRepositoryImplTest {

    private MembershipRepositoryImpl membershipRepositoryImpl;

    MembershipBuilder membershipBuilder = new MembershipBuilder();

    String memId = "16516515";
    String memCode = "ST002";
    String memTypeName = "Student member" ;

    String updatedMemTypeName = "International member";

    MemberType memberType = MemTypeBuilder.getMemberType(memCode,memTypeName);

    MemberType updatedMemberType = MemTypeBuilder.getMemberType(memCode, updatedMemTypeName);

    String memId2 = "15156515";
    String memCode2 = "FT003";
    String memTypeName2 = "Full member" ;

    MemberType memberType2 = MemTypeBuilder.getMemberType(memCode2,memTypeName2);

    Membership membership = MembershipBuilder.getMembership(memberType, memId);

    Membership updatedMembership = MembershipBuilder.getMembership(updatedMemberType, memId);

    Membership membership2 = MembershipBuilder.getMembership(memberType2, memId2);

    @Before
    public void setUp() throws Exception {
        this.membershipRepositoryImpl = MembershipRepositoryImpl.getMemRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(membership.hashCode(), this.membershipRepositoryImpl.create(membership).hashCode());
        this.membershipRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.membershipRepositoryImpl.create(membership);
        this.membershipRepositoryImpl.update(updatedMembership);
        Assert.assertEquals("International member", this.membershipRepositoryImpl.read(updatedMembership.getMembershipID()).getMemType().getMemTypeName());
        this.membershipRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.membershipRepositoryImpl.create(membership);
        this.membershipRepositoryImpl.create(membership2);
        this.membershipRepositoryImpl.delete(membership.getMembershipID());

        Assert.assertEquals(null, this.membershipRepositoryImpl.read(membership.getMembershipID()));
        this.membershipRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.membershipRepositoryImpl.create(membership);
        Assert.assertEquals(true, this.membershipRepositoryImpl.read(membership.getMembershipID()) instanceof Membership);
        System.out.println(this.membershipRepositoryImpl.read(membership.getMembershipID()));
        this.membershipRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.membershipRepositoryImpl.create(membership);
        ArrayList<Membership> customer = this.membershipRepositoryImpl.getAll();
        Assert.assertEquals(1, customer.size());
        this.membershipRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.membershipRepositoryImpl.create(membership);
        ArrayList<Membership> customer = this.membershipRepositoryImpl.getAll();
        this.membershipRepositoryImpl.removeAll();
        Assert.assertEquals( 0,customer.size());
    }
}