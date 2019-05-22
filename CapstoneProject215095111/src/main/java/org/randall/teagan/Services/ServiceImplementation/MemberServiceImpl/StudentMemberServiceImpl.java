package org.randall.teagan.Services.ServiceImplementation.MemberServiceImpl;

import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Repositories.Implementation.MembershipRepositoryImpl.StudentMembershipRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.MemberServiceInterface.StudentMemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("StudentMemberServiceImpl")
public class StudentMemberServiceImpl implements StudentMemberServiceInterface {

    @Autowired
    @Qualifier("StudentMembershipRepository")
    private StudentMembershipRepositoryImpl studentMembershipRepositoryImpl;

    @Override
    public StudentMember create(StudentMember studentMember) {
        return studentMembershipRepositoryImpl.create(studentMember);
    }

    @Override
    public StudentMember update(StudentMember studentMember) {
        return studentMembershipRepositoryImpl.update(studentMember);
    }

    @Override
    public void delete(String id) {
        studentMembershipRepositoryImpl.delete(id);
    }

    @Override
    public StudentMember read(String id) {
        return studentMembershipRepositoryImpl.read(id);
    }

    @Override
    public ArrayList<StudentMember> getAll() {
        return studentMembershipRepositoryImpl.getAll();
    }
}
