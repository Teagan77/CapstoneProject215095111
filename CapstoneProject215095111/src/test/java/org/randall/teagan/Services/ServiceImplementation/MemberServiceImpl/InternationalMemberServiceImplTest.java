package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Factory.MembershipBuilders.InternationalMemBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.InternationalMemRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InternationalMemberServiceImplTest {

    private InternationalMemRepositoryImpl internationalMemRepositoryImpl;
    private InternationalMember firstIntMember;

    private InternationalMember getSaved(){
        ListIterator<InternationalMember> listItr = this.internationalMemRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception{
        this.internationalMemRepositoryImpl = InternationalMemRepositoryImpl.getInternationalMemRepositoryImpl();
        this.firstIntMember = InternationalMemBuilder.getInternationalMember("INT-009", "International Member", "French", "215095111");
    }

    @Test
    public void a_create() {
        InternationalMember createdInternationalMember = this.internationalMemRepositoryImpl.create(this.firstIntMember);
        System.out.println("In create, created = " + createdInternationalMember);
        Assert.assertNotNull(createdInternationalMember);
        Assert.assertSame(createdInternationalMember, this.firstIntMember);
    }

    @Test
    public void c_update() {
        String newCode = "INT-MEM-001";
        InternationalMember updatedInternationalMember = new InternationalMember.InternationalMemBuilder().copy(getSaved()).memCode(newCode).build();
        System.out.println("In update, updated = " + updatedInternationalMember);
        this.internationalMemRepositoryImpl.update(updatedInternationalMember);
        Assert.assertSame(newCode, updatedInternationalMember.getMemCode());
    }

    @Test
    public void e_delete() {
        InternationalMember savedFullTimeMember = getSaved();
        this.internationalMemRepositoryImpl.delete(savedFullTimeMember.getInternationalMemID());
        d_getAll();
    }

    @Test
    public void b_read() {
        InternationalMember savedFullTimeMember = getSaved();
        InternationalMember readFullTimeMember = this.internationalMemRepositoryImpl.read(savedFullTimeMember.getInternationalMemID());
        System.out.println("In read, read = "+ readFullTimeMember);
        Assert.assertSame(readFullTimeMember, savedFullTimeMember);
    }

    @Test
    public void d_getAll() {
        ArrayList<InternationalMember> internationalMembers = this.internationalMemRepositoryImpl.getAll();
        System.out.println("In getall, all = " + internationalMembers);
    }
}