package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.MembershipRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceImplTest {

    private MembershipRepositoryImpl membershipRepositoryImpl;
    private MemberType memberType;
    private Membership firstMember;

    private Membership getSaved(){
        ListIterator<Membership> listItr = this.membershipRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception{
        this.membershipRepositoryImpl = MembershipRepositoryImpl.getMemRepositoryImpl();
        this.memberType = MemTypeBuilder.getMemberType("FT009", "Fulltime");
        this.firstMember = MembershipBuilder.getMembership(memberType, "2181598");
    }

    @Test
    public void a_create() {
        Membership createdMember = this.membershipRepositoryImpl.create(this.firstMember);
        System.out.println("In create, created = " + createdMember);
        Assert.assertNotNull(createdMember);
        Assert.assertSame(createdMember, this.firstMember);
    }

    @Test
    public void c_update() {
        String newCode = "FT-MEM-001";
        Membership updatedMember = new Membership.MembershipBuilder().copy(getSaved()).membershipID(newCode).build();
        System.out.println("In update, updated = " + updatedMember);
        this.membershipRepositoryImpl.update(updatedMember);
        Assert.assertSame(newCode, updatedMember.getMembershipID());
    }

    @Test
    public void e_delete() {
        Membership savedMember = getSaved();
        this.membershipRepositoryImpl.delete(savedMember.getMembershipID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Membership savedMember = getSaved();
        Membership readMember = this.membershipRepositoryImpl.read(savedMember.getMembershipID());
        System.out.println("In read, read = "+ readMember);
        Assert.assertSame(readMember, savedMember);
    }

    @Test
    public void d_getAll() {
        ArrayList<Membership> members = this.membershipRepositoryImpl.getAll();
        System.out.println("In getall, all = " + members);
    }
}