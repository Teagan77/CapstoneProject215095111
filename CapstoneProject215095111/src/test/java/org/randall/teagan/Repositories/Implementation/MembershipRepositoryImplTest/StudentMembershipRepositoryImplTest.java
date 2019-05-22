package org.randall.teagan.Repositories.Implementation.MembershipRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Factory.MembershipBuilders.StudentMemberBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.StudentMembershipRepositoryImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentMembershipRepositoryImplTest {

    private StudentMembershipRepositoryImpl studentMembershipRepositoryImpl;
    private StudentMemberBuilder studentMemberBuilder = new StudentMemberBuilder();

    String memName = "Student Member";
    String memCode = "ST004";
    String studNo = "615165165";

    String updatedMemCode = "STDNT001";

    String memName2 = "Student Member";
    String memCode2 = "ST004";
    String studNo2 = "215095111";

    StudentMember firstStudMem = StudentMemberBuilder.getStudMember(memCode,memName,studNo);
    StudentMember updatedFirstStudMem = StudentMemberBuilder.getStudMember(updatedMemCode,memName,memCode);
    StudentMember secondStudMem = StudentMemberBuilder.getStudMember(memCode2,memName2,studNo2);

    @Before
    public void setUp() throws Exception {
        this.studentMembershipRepositoryImpl = StudentMembershipRepositoryImpl.getStudentMembershipRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstStudMem.hashCode(), this.studentMembershipRepositoryImpl.create(firstStudMem).hashCode());
        this.studentMembershipRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.studentMembershipRepositoryImpl.create(firstStudMem);
        this.studentMembershipRepositoryImpl.update(updatedFirstStudMem);
        Assert.assertEquals("STDNT001", this.studentMembershipRepositoryImpl.read(updatedFirstStudMem.getStudNo()).getMemCode());
        this.studentMembershipRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.studentMembershipRepositoryImpl.create(firstStudMem);
        this.studentMembershipRepositoryImpl.create(secondStudMem);
        this.studentMembershipRepositoryImpl.delete(firstStudMem.getStudNo());

        assertEquals(null, this.studentMembershipRepositoryImpl.read(firstStudMem.getStudNo()));
        this.studentMembershipRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.studentMembershipRepositoryImpl.create(firstStudMem);
        assertEquals(true, this.studentMembershipRepositoryImpl.read(firstStudMem.getStudNo()) instanceof StudentMember);
        System.out.println(this.studentMembershipRepositoryImpl.read(firstStudMem.getStudNo()));
        this.studentMembershipRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.studentMembershipRepositoryImpl.create(firstStudMem);
        ArrayList<StudentMember> studentMembers = this.studentMembershipRepositoryImpl.getAll();
        Assert.assertEquals(1, studentMembers.size());
        this.studentMembershipRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.studentMembershipRepositoryImpl.create(firstStudMem);
        ArrayList<StudentMember> studentMembers = this.studentMembershipRepositoryImpl.getAll();
        this.studentMembershipRepositoryImpl.removeAll();
        assertEquals( 0,studentMembers.size());
    }
}