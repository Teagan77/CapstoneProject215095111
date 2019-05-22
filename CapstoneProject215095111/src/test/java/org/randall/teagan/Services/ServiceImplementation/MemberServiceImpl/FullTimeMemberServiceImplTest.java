package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Factory.MembershipBuilders.FullTimeMemberBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.FullMemRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullTimeMemberServiceImplTest {

    private FullMemRepositoryImpl fullMemRepositoryImpl;
    private FullTimeMember firstMember;

    private FullTimeMember getSaved(){
        ListIterator<FullTimeMember> listItr = this.fullMemRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before public void setUp() throws Exception{

        this.fullMemRepositoryImpl = FullMemRepositoryImpl.getFullMemRepositoryImpl();
        this.firstMember = FullTimeMemberBuilder.getFullTimeMember("FTMEM001", "Fulltime", "050122");
    }

    @Test
    public void a_create() {
        FullTimeMember createdFullTimeMember = this.fullMemRepositoryImpl.create(this.firstMember);
        System.out.println("In create, created = " + createdFullTimeMember);
        Assert.assertNotNull(createdFullTimeMember);
        Assert.assertSame(createdFullTimeMember, this.firstMember);
    }

    @Test
    public void c_update() {
        String newCode = "FT-MEM-001";
        FullTimeMember updatedFullTimeMember = new FullTimeMember.FullTimeMemberBuilder().copy(getSaved()).memCode(newCode).build();
        System.out.println("In update, updated = " + updatedFullTimeMember);
        this.fullMemRepositoryImpl.update(updatedFullTimeMember);
        Assert.assertSame(newCode, updatedFullTimeMember.getMemCode());
    }

    @Test
    public void e_delete() {
        FullTimeMember savedFullTimeMember = getSaved();
        this.fullMemRepositoryImpl.delete(savedFullTimeMember.getMemCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        FullTimeMember savedFullTimeMember = getSaved();
        FullTimeMember readFullTimeMember = this.fullMemRepositoryImpl.read(savedFullTimeMember.getFullTimeMemCode());
        System.out.println("In read, read = "+ readFullTimeMember);
        Assert.assertSame(readFullTimeMember, savedFullTimeMember);
    }

    @Test
    public void d_getAll() {
        ArrayList<FullTimeMember> fullTimeMembers = this.fullMemRepositoryImpl.getAll();
        System.out.println("In getall, all = " + fullTimeMembers);
    }

}