package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Factory.MembershipBuilders.StudentMemberBuilder;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.StudentMembershipRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMemberServiceImplTest {

    private StudentMembershipRepositoryImpl studentMembershipRepositoryImpl;
    private StudentMember firstStudentMember;

    private StudentMember getSaved(){
        ListIterator<StudentMember> listItr = this.studentMembershipRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.studentMembershipRepositoryImpl = StudentMembershipRepositoryImpl.getStudentMembershipRepositoryImpl();
        this.firstStudentMember = StudentMemberBuilder.getStudMember("STD-009", "Student Member", "215095111");
    }

    @Test
    public void a_create() {
        StudentMember createdStudentMember = this.studentMembershipRepositoryImpl.create(this.firstStudentMember);
        System.out.println("In create, created = " + createdStudentMember);
        Assert.assertNotNull(createdStudentMember);
        Assert.assertSame(createdStudentMember, this.firstStudentMember);
    }

    @Test
    public void c_update() {
        String newTypeName = "Student-Membership";
        StudentMember updatedStudentMember = new StudentMember.StudentMemBuilder().copy(getSaved()).memType(newTypeName).build();
        System.out.println("In update, updated = " + updatedStudentMember);
        this.studentMembershipRepositoryImpl.update(updatedStudentMember);
        Assert.assertSame(newTypeName, updatedStudentMember.getMemTypeName());
    }

    @Test
    public void e_delete() {
        StudentMember savedStudentMember = getSaved();
        this.studentMembershipRepositoryImpl.delete(savedStudentMember.getStudNo());
        d_getAll();
    }

    @Test
    public void b_read() {
        StudentMember savedStudentMember = getSaved();
        StudentMember readStudentMember = this.studentMembershipRepositoryImpl.read(savedStudentMember.getStudNo());
        System.out.println("In read, read = "+ readStudentMember);
        Assert.assertSame(readStudentMember, savedStudentMember);
    }

    @Test
    public void d_getAll() {
        ArrayList<StudentMember> studentMembers = this.studentMembershipRepositoryImpl.getAll();
        System.out.println("In getall, all = " + studentMembers);
    }
}